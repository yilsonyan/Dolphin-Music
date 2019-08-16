package cn.jd.Thread.cas_atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    //    public static volatile int count = 0;
    public static volatile AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[20];

        //新建20个线程、每个线程执行1000次count++，共执行20000次
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    count.incrementAndGet();
                }
            });
            threads[i].start();
            threads[i].join();//TODO 【重点】等待该线程终止 join可保证多线程的执行顺序
        }

        //不使用join()时，主线程打印的结果是5000、或者8000、11354等，正确应该是20*1000=20000
        System.out.println(count);
    }





}
