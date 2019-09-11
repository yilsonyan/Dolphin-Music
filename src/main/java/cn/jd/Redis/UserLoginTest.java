package cn.jd.Redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    //存入hash类型
    //   http://localhost:8080/h1
    @GetMapping("hash")
    Object hash() throws Exception {
        //用时统计
        long start = System.currentTimeMillis();
        redisTemplate.boundHashOps("hash_k1").put("hash_k2", "hash_value");
        Object hv1 = redisTemplate.boundHashOps("hash_k1").get("hash_k2");
        long end = System.currentTimeMillis();
        return end - start + hv1.toString();
    }


    //存入2000万个用户登录信息
    //   http://localhost:8080/add
    @GetMapping("add")
    Object add() throws Exception {
        //用时统计
        long start = System.currentTimeMillis();
        for (int i = 0; i < 20000000; i++) {
            redisTemplate.boundHashOps("userLogin").put("username_" + i, "password_" + i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }


    //   http://localhost:8080/login
    @GetMapping("login")
    Object userLogin() throws Exception {
        //用时统计
        long start = System.currentTimeMillis();
        Object userLogin = redisTemplate.boundHashOps("userLogin").get("username_5000000");

        long end = System.currentTimeMillis();
        return end - start + "(" + userLogin + ")";//2毫秒
    }


}
