package cn.jd.Thread.cas_atomic;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;



public class TestAtomicBooleanLock {


    final static int THREAD_NUM = 200;
    static int x = 0;

    private AtomicBoolean atomicBoolean = new AtomicBoolean(false);


    /**
     * 测试 AtomicBoolean 锁
     */
    @Test
    public void testAtomicBooleanLock() throws Exception {
        CountDownLatch latch = new CountDownLatch(THREAD_NUM);

        // 使用自定义的自旋锁（利用原子变量的CAS实现）


        for (int i = 0; i < THREAD_NUM; i++) {
            // 启动子线程
            new Thread(() -> {
                // 每个线程循环多次，频繁上锁，解锁。
                for (int n = 0; n < 100; n++) {


                    while (!atomicBoolean.compareAndSet(false,true)){

                    }


                    x++;


                    //解锁
                    atomicBoolean.set(false);

                }
                latch.countDown();    // 子线程通知主线程，工作完毕。

            }).start();
        }

        latch.await();    // 主线程等待所有子线程结束。

        System.out.println(x);    // 最终打印结果：20000 ，未出现线程不安全的异常。
    }







}
