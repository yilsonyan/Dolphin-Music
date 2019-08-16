package cn.jd.Thread.cas_atomic;

import org.junit.Test;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 利用原子变量的CAS，实现的一个自定义自旋锁
 */
public class SpinLock {

    private AtomicReference<Thread> owner = new AtomicReference<>();

    //加锁
    public void lock() {
        //获取当前线程对象
        Thread current = Thread.currentThread();
        //当owner持有线程不为空时，循环等待；当owner持有线程为空时，将owner持有线程设为当前线程，退出循环
        while (!owner.compareAndSet(null, current)) {
            // TODO 【重点】：拿不到owner的线程，不断的在死循环
        }
    }


    //释放锁
    public void unLock() {
        /*cn.jd.Thread current = cn.jd.Thread.currentThread();
        //执行完成后，将owner持有线程重新置为空，相当于释放锁
        boolean compareAndSet = owner.compareAndSet(current, null);*/

        //简便写法
        owner.set(null);
    }


    @Test
    public void testLock() {
        //让owner不为空
        owner.set(Thread.currentThread());

        //预期为空，实际不为空，陷入循环等待，即被上锁
        lock();
    }


}