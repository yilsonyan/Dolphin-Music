package cn.jd.math;

import org.junit.Test;

import java.security.SecureRandom;
import java.util.Random;

public class RandomTest {

    /**
     * 伪随机数
     * 创建Random实例时，如果不给定种子，就使用系统当前时间戳作为种子，得到的伪随机数序列就不同。
     * TODO 如果我们在创建Random实例时指定一个种子，就会得到完全确定的随机数序列：
     */
    @Test
    public void ran() {
        Random r = new Random(12345);
        for (int i = 0; i < 10; i++) {
            System.out.print("," + r.nextInt(100)); //每次都是确定的：51, 80, 41, 28, 55...
        }
    }


    /**
     * 真随机数
     * SecureRandom的安全性是通过操作系统提供的安全的随机种子来生成随机数。这个种子是通过CPU的热噪声、读写磁盘的字节、网络流量等各种随机事件产生的“熵”。
     *
     * 在密码学中，安全的随机数非常重要。如果使用不安全的伪随机数，所有加密体系都将被攻破。因此，时刻牢记必须使用SecureRandom来产生安全的随机数。
     */
    @Test
    public void ran2() {
        SecureRandom sr = new SecureRandom();
        System.out.println(sr.nextInt(100));
    }




}
