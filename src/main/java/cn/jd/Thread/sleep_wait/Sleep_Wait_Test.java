package cn.jd.Thread.sleep_wait;

public class Sleep_Wait_Test {

    public static void main(String[] args) {
        Object lock = new Object();


        Thread threadA = new Thread( () -> {
            System.out.println("thread a try to get lock");
            synchronized (lock){
                System.out.println("thread a get a lock");
                try {
                    Thread.sleep(200);
                    System.out.println("thread a do a wait method");
                    lock.wait(1000);//等待
                    System.out.println("thread a wait is done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();


        Thread threadB = new Thread( () -> {
            System.out.println("thread b try to get lock");
            synchronized (lock){
                System.out.println("thread b get a lock");
                try {
                    Thread.sleep(200);
                    System.out.println("thread b do a wait method");
                    lock.wait(1000);//睡
                    System.out.println("thread b wait is done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadB.start();






    }




}
