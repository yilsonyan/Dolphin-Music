package cn.jd.Thread.sleep_wait;

public class Sleep_Wait_Test {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();


        Thread threadA = new Thread( () -> {
            System.out.println("thread a try to get lock");
            synchronized (lock){
                System.out.println("thread a get a lock");
                try {
                    Thread.sleep(200);
                    System.out.println("thread a do a wait method");
                    lock.wait(1000);//等待，前后是不连续的，说明wait释放了锁
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
                    System.out.println("thread b do a sleep method");
                    Thread.sleep(200);  //sleep前后是连续的，说明sleep没有释放锁
                    System.out.println("thread b wait is done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadB.start();






    }




}
