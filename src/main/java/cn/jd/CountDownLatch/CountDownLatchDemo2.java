package cn.jd.CountDownLatch;


import cn.jd.util.HttpUrlUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo2 {


    /**
     * 测试3000个线程同时开始处理
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 1; i <= 3000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //先陷入等待
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //String url = "https://www.baidufe.com/test-post.php";
                    String url = "http://www.baidufe.com/test-post.php";
                    Map<String, String> map = new HashMap<>();
                    map.put("username", "postman");
                    map.put("password", "123456");
                    String sendPost = HttpUrlUtil.sendPost(url, map);
                    System.out.println(sendPost);
                    System.out.println(Thread.currentThread().getName() + " is done");
                }
            }, "thread-" + i).start();
        }
        //让所有线程都启动完成
        Thread.sleep(2000);
        //countDownLatch为0时，处于await()的线程全部开跑
        countDownLatch.countDown();
        System.out.println(Thread.currentThread().getName() + " count down is ok");
    }


    /**
     * Runnable共享 cn.jd.CountDownLatch 对象的方式，多个 Runnable 构造函数里面传递同一个 cn.jd.CountDownLatch
     */
    public static class MyRunnable implements Runnable {
        private final CountDownLatch countDown;
        private final CountDownLatch await;

        //构造函数
        public MyRunnable(CountDownLatch countDown, CountDownLatch await) {
            this.countDown = countDown;
            this.await = await;
        }

        public void run() {
            try {
                countDown.await();//等待主线程执行完毕，获得开始执行信号...
                System.out.println("处于等待的线程开始自己预期工作......");
                await.countDown();//完成预期工作，发出完成信号...
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
