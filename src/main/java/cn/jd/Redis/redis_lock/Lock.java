package cn.jd.Redis.redis_lock;

/**
 * 全局锁，包括锁的名称
 * Created by yanbinyuan on 2019/5/15
 */

public class Lock {
    private String name;
    private String value;

    public Lock(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

}