package cn.jd.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {


    /**
     * CountDownLatch是一个用来控制并发的很常见的工具，
     * 它允许一个或者多个线程等待其他的线程执行到某一操作，
     * 比如说需要去解析一个excel的数据，为了更快的解析则每个sheet都使用一个线程去进行解析，
     * 但是最后的汇总数据的工作则需要等待每个sheet的解析工作完成之后才能进行，
     * 这就可以使用CountDownLatch。
     */
    public static void main(String[] args) throws InterruptedException{

        CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //do something
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " is done");
                countDownLatch.countDown();
            }
        }, "thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //do something
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " is done");
                countDownLatch.countDown();
            }
        }, "thread2");


        thread1.start();
        thread2.start();

        //等待countDownLatch为0时再执行await()后面的
        countDownLatch.await();

        System.out.println(Thread.currentThread().getName() +  " count down is ok");
    }

}
