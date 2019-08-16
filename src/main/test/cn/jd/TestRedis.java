package cn.jd;

import cn.jd.Redis.RedisUtil;
import cn.jd.Redis.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

//@SpringBootTest(classes =  Application.class,properties = "redis-sentinel/applicationContext-redis.xml")
@SpringBootTest(classes =  Application.class)
@RunWith(SpringRunner.class)
public class TestRedis {

    private static int ExpireTime = 10;   // redis中存储的过期时间10s

    @Resource
    private RedisUtil redisUtil;

    /**
     * 设置值
     */
    @Test
    public void testRedisSet() {
        UserEntity userEntity =new UserEntity();
        userEntity.setId(1L);
        userEntity.setGuid("1");
        userEntity.setName("Jack");
        userEntity.setAge(20);
        userEntity.setCreateTime(new Date());

        //redisUtil.set("k1",userEntity,ExpireTime);//设置同时设定过期事件
        redisUtil.set("k1",userEntity);
    }


    /**
     * 获取值
     */
    @Test
    public void testRedisGet() {
//        Object k1 = redisUtil.get("k1");
        UserEntity k1 = (UserEntity)redisUtil.get("k1");
        System.out.println(k1);


    }


    /**
     * 单独设置过期值
     */
    @Test
    public void testRedisExpire() {
        redisUtil.expire("k1",ExpireTime);
    }



}
