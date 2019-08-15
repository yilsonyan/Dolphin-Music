package Thread.cas_atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    private static final int THREADS_CONUT = 20;
    //    public static volatile int count = 0;
    public static volatile AtomicInteger count = new AtomicInteger(0);

    public static void increase() {
        //        count++;
        count.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_CONUT];

        //新建20个线程、每个线程执行1000次count++，共执行20000次
        for (int i = 0; i < THREADS_CONUT; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    increase();
                }
            });
            threads[i].start();
            //threads[i].join();
        }

        //主线程打印的结果是5000、或者8000、11354等
        System.out.println(count);
    }





}
