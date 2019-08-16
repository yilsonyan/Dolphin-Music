package cn.jd;

import cn.jd.Redis.redis_lock.DistributedLockHandler;
import cn.jd.Redis.redis_lock.Lock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes =  Application.class,properties = "redis-sentinel/applicationContext-redis.xml")
@SpringBootTest(classes = Application.class)
public class TestRedisLock {


    /**
     * 测试Redis锁
     */
    @Test
    public void testRedisLock() {
        DistributedLockHandler distributedLockHandler = new DistributedLockHandler();
        Lock lock = new Lock("lock1", "value1");

        if (distributedLockHandler.tryLock(lock)) {
            System.out.println("-------------------------------------");
            distributedLockHandler.releaseLock(lock);
        }
    }

}
