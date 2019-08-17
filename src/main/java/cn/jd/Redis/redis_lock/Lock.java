package cn.jd.Redis.redis_lock;

import lombok.Data;

/**
 * 全局锁，包括锁的名称
 * Created by yanbinyuan on 2019/5/15
 */
@Data
public class Lock {

    private String name;
    private String value;


}