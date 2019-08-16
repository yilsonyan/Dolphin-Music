package cn.jd;

import cn.jd.Redis.RedisUtil;
import cn.jd.Redis.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes =  Application.class,properties = "redis-sentinel/applicationContext-redis.xml")
@SpringBootTest(classes =  Application.class)
@RestController
public class TestRedis {

    private static int ExpireTime = 60;   // redis中存储的过期时间60s

    @Resource
    private RedisUtil redisUtil;

    @Autowired
    StringRedisTemplate strTemplate;

    @Resource(name = "redisTemplate")
    RedisTemplate template;

    /**
     * 设置值
     */
    @Test
    public void testRedisSet() {
        UserEntity userEntity =new UserEntity();
        userEntity.setId(Long.valueOf(1));
        userEntity.setGuid(String.valueOf(1));
        userEntity.setName("ZhangSan");
        userEntity.setAge(String.valueOf(20));
        userEntity.setCreateTime(new Date());

        //redisUtil.set("k1","v1",ExpireTime);
        redisUtil.set("k1",userEntity);
    }


    /**
     * 获取值
     */
    @Test
    public void testRedisGet() {
        Object k1 = redisUtil.get("k1");
        System.out.println(k1);
    }


    /**
     * 设置过期值
     */
    @Test
    public void testRedisExpire() {
        redisUtil.expire("k1",ExpireTime);
    }



}
