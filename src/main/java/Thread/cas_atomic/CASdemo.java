package Thread.cas_atomic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class CASdemo {

    @Test
    public void atomicInteger() {
        //初始值5
        AtomicInteger atomicInteger = new AtomicInteger(5);
        //和5比较,设置为10
        System.out.println("预期值:5,当前值:"+atomicInteger);
        System.out.println("是否设置成功:"+atomicInteger.compareAndSet(5, 10));
        //和5比较,设置为15
        System.out.println("预期值:5,当前值:"+atomicInteger);
        System.out.println("是否设置成功:"+atomicInteger.compareAndSet(5, 15));
        System.out.println("当前值:"+atomicInteger);
    }



    public static void main(String[] args) {
        //让owner不为空
        owner.set(Thread.currentThread());
        //预期为空，实际不为空，陷入循环等待
        lock();
    }


    private static AtomicReference<Thread> owner = new AtomicReference<>();

    public static void lock(){
        //获取当前线程对象
        Thread current = Thread.currentThread();
        //当owner持有线程不为空时，循环等待
        while (!owner.compareAndSet(null, current)) {
            //当owner持有线程为空时，将owner持有线程设为当前线程，退出循环
        }
    }

    public static void unlock() {
        Thread current = Thread.currentThread();
        //执行完成后，将owner持有线程重新置为空，相当于释放锁
        owner.compareAndSet(current, null);
    }





}