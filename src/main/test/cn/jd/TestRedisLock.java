package cn.jd;

import cn.jd.Redis.RedisUtil;
import cn.jd.Redis.redis_lock.DistributedLockHandler;
import cn.jd.Redis.redis_lock.Lock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;


//@SpringBootTest(classes =  Application.class,properties = "redis-sentinel/applicationContext-redis.xml")
@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class TestRedisLock {


    /**
     * 测试Redis锁
     */
    @Test
    public void testRedisLockUtil() {
        DistributedLockHandler distributedLockHandler = new DistributedLockHandler();
        Lock lock = new Lock("lock1", "value1");

        if (distributedLockHandler.tryLock(lock)) {
            System.out.println("-------------------------------------");
            distributedLockHandler.releaseLock(lock);
        }
    }


    /**
     * 测试自定义的自旋锁（利用原子变量的CAS实现）
     */
    final static int THREAD_NUM = 200;
    static int x = 0;
    AtomicInteger xAtomic = new AtomicInteger(0);

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 测试自定义Redis锁
     */
    @Test
    public void testMyRedisLock() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(THREAD_NUM);

        // 使用自定义的自旋锁（利用原子变量的CAS实现）


        for (int i = 0; i < THREAD_NUM; i++) {
            // 启动子线程
            new Thread(() -> {
                // 每个线程循环多次，频繁上锁，解锁。
                for (int n = 0; n < 100; n++) {

                    //上锁
                    synchronized ("") {
                        while (redisTemplate.opsForValue().setIfAbsent("k1","v1")){

                        }
                    }


                    x++;

                    //synchronized ("") {
                        //解锁
                        redisTemplate.delete("k1");
                    //}

                }
                latch.countDown();    // 子线程通知主线程，工作完毕。

            }).start();
        }

        latch.await();    // 主线程等待所有子线程结束。

        System.out.println(x);    // 最终打印结果：20000 ，未出现线程不安全的异常。
    }






}
