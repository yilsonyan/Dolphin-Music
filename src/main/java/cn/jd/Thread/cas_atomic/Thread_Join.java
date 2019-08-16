package cn.jd.Thread.cas_atomic;

/**
 * 现在有T1、T2、T3三个线程，如何保证执行顺序
 * 你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
 */
public class Thread_Join {

    public static void main(String[] args) {
        //初始化线程t1,由于后续有匿名内部类调用这个对象,需要用final修饰
        final Thread t1 = new Thread(
            () -> System.out.println("t1 is running")
        );


        //初始化线程t2,由于后续有匿名内部类调用这个对象,需要用final修饰
        final Thread t2 = new Thread(
                () ->{
                try {
                    /**
                     * 邀请t1线程先执行，本线程陷入等待，t1线程执行完后，本线程再接着往下执行
                     *
                     * while (isAlive()) {
                     *    wait(0);
                     * }
                     *
                     * 查看源码可以知道join()和join(long millis, int nanos)最终都是调用join(long millis),
                     * 对于join(long millis)来说中间的逻辑就是如果给定的等待时间是0的话，表示主线程永远的等待，直到子线程执行完毕。
                     * 至于t1.join()为什么不是子线程的暂停等待，而是主线程？
                     * 借用大神的理解是调用的join()然后调用了wait方法其中wait是Object类的方法，把对象t1当成是一个普通的对象，
                     * 调用wait方法是让调用方法的线程挂起，和调用的是哪个对象上的wait方法没关系。
                     */
                    t1.join();//邀请t1线程先执行，本线程陷入等待，t1线程执行完后，本线程再接着往下执行
                    System.out.println("t2 is running");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        });


        //初始化线程t3
        Thread t3 = new Thread(
                () -> {
                try {
                    //t2调用join方法,t3会等待t2运行完之后才会开始执行后续代码
                    t2.join();
                    System.out.println("t3 is running");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        });


        //依次启动3个线程
        /*t1.start();
        t3.start();
        t2.start();*/

        //乱序启动3个线程
        t3.start();
        t1.start();
        t2.start();
    }
}
