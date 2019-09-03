package cn.jd.Thread.upload_sales;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledFuture;

/**
 * 销售记录上传至MIS任务调度
 *
 * @author yanbinyuan
 * @date 2019年7月3日
 * @version jdk1.8
 */
@Component
public class UploadSalesTaskService {


    class UploadSalesRunnable implements Runnable {
        int i = 0;
        @Override
        public void run() {
            System.out.println("系统已启动"+ (i++) +"分钟!");
        }
    }

    //日志
    private Logger logger = LoggerFactory.getLogger(UploadSalesTaskService.class);


    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    /**
     * 注册线程池
     * @return
     */
    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        ThreadPoolTaskScheduler executor = new ThreadPoolTaskScheduler();
        //executor.setPoolSize(20);
        executor.setThreadNamePrefix("UploadSales-");
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //executor.setAwaitTerminationSeconds(60);
        return executor;
    }

    /**
     * 线程操作对象
     */
    private ScheduledFuture<?> future;


    /**
     * 启动任务
     * @author yanbinyuan
     * @date 2019年7月3日
     * @version jdk1.8
     */
    public void start() {
        try {
            //读取数据库设置的时间
            String second = "60";
            CronTrigger cronTrigger = CronTriggerUtil.secondToCronTrigger(second);

            //根据cronTrigger对象设置的表达式开启线程
            future = threadPoolTaskScheduler.schedule(new UploadSalesRunnable(), cronTrigger);
            logger.info("销售记录上传线程启动成功，上传间隔时间为"+second+"秒！");
        } catch (Exception e) {
            logger.error("销售记录上传线程启动异常！"+e.getMessage());
        }
    }



    /**
     * 变更任务间隔
     * @author yanbinyuan
     * @date 2019年7月3日
     * @version jdk1.8
     */
    public void change(String second) {
        try {
            stop();
            CronTrigger cronTrigger = CronTriggerUtil.secondToCronTrigger(second);
            //开启新线程
            future = threadPoolTaskScheduler.schedule(new UploadSalesRunnable(), cronTrigger);
            logger.info("change sales record upload task interval to "+second+" seconds");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("变更任务间隔异常！{}",e.getMessage());
            throw new RuntimeException("变更任务间隔异常！"+e.getMessage());
        }
    }



    /**
     * 停止任务
     * @author yanbinyuan
     * @date 2019年7月3日
     * @version jdk1.8
     */
    public void stop() {
        try {
            if (future != null) {
                future.cancel(true);
                logger.info("sales record upload task stopped");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("停止任务异常！{}",e.getMessage());
            throw new RuntimeException("停止任务异常！"+e.getMessage());
        }
    }



}
