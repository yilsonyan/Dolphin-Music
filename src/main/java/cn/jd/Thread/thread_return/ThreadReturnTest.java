package cn.jd.Thread.thread_return;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadReturnTest {

    /**
     * 线程类的run方法没有返回值，要获取线程的返回值怎么办？
     */
    String returnValue;

    //发现主线程先于子线程执行完毕，打印出null
    @Test
    public void test0() throws Exception{
        new Thread(() -> returnValue = "I have data now." ).start();
        System.out.println(returnValue);
    }

    /**
     * 第一种：主线程等待法
     */
    @Test
    public void test1() throws Exception{
        Thread thread = new Thread(() -> returnValue = "I have data now.");
        thread.start();
        while (returnValue == null){
            Thread.yield();
        }
        System.out.println(returnValue);
    }


    /**
     * 第二种：join方法
     */
    @Test
    public void test2() throws Exception{
        Thread thread = new Thread(() -> returnValue = "I have data now.");
        thread.start();
        thread.join();

        System.out.println(returnValue);
    }


    /**
     * 第三种：线程类参数传递 FutureTask ，创建 FutureTask 对象，参数传递 Callable 接口
     */
    @Test
    public void test3() throws Exception{
        class MyCallable implements Callable{
            @Override
            public String call() throws Exception {
                return "some data.";
            }
        }
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        //创建参数是 FutureTask 的线程
        Thread thread = new Thread(futureTask);
        thread.start();

        //FutureTask 的isDone方法返回成功表示线程结果；get获取 Callable 函数式接口的返回值
        while (!futureTask.isDone()){
            System.out.println("还未完成!");
            //futureTask.cancel(true);//futureTask对象可以结束线程
        }

        //get的源码：awaitDone，一直在等待结果返回，不用写代码手动等待
        String s = futureTask.get();
        System.out.println(s);
    }






}
