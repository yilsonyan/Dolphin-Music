package cn.jd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;


//@SpringBootTest(classes =  Application.class,properties = "redis-sentinel/applicationContext-redis.xml")
@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class TestFileLock {


    final static int THREAD_NUM = 200;
    static int x = 0;


    /**
     * 测试文件分布式锁
     */
    @Test
    public void testMyFileLock() throws Exception {
        CountDownLatch latch = new CountDownLatch(THREAD_NUM);

        // 使用自定义的自旋锁（利用原子变量的CAS实现）


        for (int i = 0; i < THREAD_NUM; i++) {
            // 启动子线程
            new Thread(() -> {
                // 每个线程循环多次，频繁上锁，解锁。
                for (int n = 0; n < 100; n++) {

                    File lockFile = new File("/Users/beyond/Desktop/lock.txt");

                    synchronized ("") {
                        //检查锁
                        while (lockFile.exists()){

                        }

                        //上锁
                        try {
                            lockFile.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }


                    x++;


                    //解锁
                    lockFile.delete();

                }
                latch.countDown();    // 子线程通知主线程，工作完毕。

            }).start();
        }

        latch.await();    // 主线程等待所有子线程结束。

        System.out.println(x);    // 最终打印结果：20000 ，未出现线程不安全的异常。
    }







}
