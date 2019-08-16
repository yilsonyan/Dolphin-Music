package cn.jd.Thread.cas_atomic;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class TestCAS {

    /**
     * CAS（Compare-and-Swap），即比较并替换，java并发包中许多Atomic的类的底层原理都是CAS。
     * 它的功能是判断内存中某个地址的值是否为预期值，如果是就改变成新值，整个过程具有原子性。
     * 具体体现于sun.misc.Unsafe类中的native方法，调用这些native方法，JVM会帮我们实现汇编指令，这些指令是CPU的原子指令，因此具有原子性。
     */
    @Test
    public void atomicInteger() {
        //初始值5
        AtomicInteger atomicInteger = new AtomicInteger(5);
        //和5比较,设置为10
        System.out.println("预期值:5,当前值:" + atomicInteger);
        System.out.println("是否设置成功:" + atomicInteger.compareAndSet(5, 10));
        //和5比较,设置为15
        System.out.println("预期值:5,当前值:" + atomicInteger);
        System.out.println("是否设置成功:" + atomicInteger.compareAndSet(5, 15));
        System.out.println("当前值:" + atomicInteger);
    }



    /**
     * 测试自定义的自旋锁（利用原子变量的CAS实现）
     */
    final static int THREAD_NUM = 20;
    static int x = 0;
    AtomicInteger xAtomic = new AtomicInteger(0);



    @Test
    public void testLock() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(THREAD_NUM);

        // 使用自定义的自旋锁（利用原子变量的CAS实现）
        SpinLock spinLock = new SpinLock();

        //JDK自带的锁
        ReentrantLock lock = new ReentrantLock();
        lock.tryLock();

        for (int i = 0; i < THREAD_NUM; i++) {
            // 启动子线程
            new Thread(() -> {
                // 每个线程循环多次，频繁上锁，解锁。
                for (int n = 0; n < 1000; n++) {
                    // TODO 【重点】：不加锁，得到的结果是19478，不为20000，存在线程安全问题
                    //  原因：变量 int x 的 x++ 自增线程不安全，不能保证原子性
                    //  i++ 的操作可以分为三步: 取值、自增、写回。
                    //   假如存在 t1 线程在 取值读到为2 后线程丢失CPU执行权，刚好有 t2 线程 自增回写了3，t1取到的值2就比实际3小，自增后还是3，因此最后会出现i自增的结果总比预计小。
                    //   由于栈是线程私有的，所以当且仅当 i 位于栈上是安全的，反之不安全。即 ---> 变量定义在方法内不会存在安全问题。
                    //x++;

                    // TODO 如果换成Atomic包的原子类，得到的结果是20000，线程安全
                    //xAtomic.incrementAndGet();

                    // TODO 【重点】：使用自定义自旋锁，得到的结果是20000，线程安全
                    spinLock.lock();
                    x++;
                    spinLock.unLock();

                    // TODO 【重点】：使用JDK自带的加锁ReentrantLock可重入锁，效果同上，得到的结果是20000，线程安全
                    /*lock.lock();
                    x++;
                    lock.unlock();*/

                }
                latch.countDown();    // 子线程通知主线程，工作完毕。

            }).start();
        }

        latch.await();    // 主线程等待所有子线程结束。

        System.out.println(x);    // 最终打印结果：20000 ，未出现线程不安全的异常。
    }


}
