package cn.jd.Thread.upload_sales;

import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.Assert;

/**
 * 任务调度时间转换工具
 *
 * @author yanbinyuan
 * @date 2019年7月3日
 * @version jdk1.8
 */
public class CronTriggerUtil {


    /**
     * 传递单位秒，转换为对应Cron表达式，并返回CronTrigger对象
     *
     * @author yanbinyuan
     * @date 2019年7月3日
     * @version jdk1.8
     */
    public static CronTrigger secondToCronTrigger(String second){
        Long seconds = Long.valueOf(second);
        Assert.isTrue(seconds > 0, "'second' must be 1 or higher");


        //表达式
        String cronExpression = "";

        //60秒以内
        if (seconds < 60){
            cronExpression = "*/"+second+" * * * * ?";
        //大于等于1分钟，小于1小时
        }else if (seconds >= 60 && seconds < 60*60) {
            Assert.isTrue(seconds % 60 == 0, "when 'second' greater than 60, it must be a multiple of 60");
            cronExpression = "0 */" + seconds/60 + " * * * ?";
        //大于等于1h小于24h
        }else if (seconds >= 60*60 && seconds < 60*60*24) {
            Assert.isTrue(seconds % (60*60) == 0, "when 'second' greater than 3600, it must be a multiple of 3600");
            cronExpression = "0 0 0/" + seconds/(60*60) + " * * ?";
        }

        CronTrigger cronTrigger = new CronTrigger(cronExpression);
        return cronTrigger;
    }



    public static void main(String[] args) {
//        CronTrigger cronTrigger = secondToCronTrigger("7200");
        CronTrigger cronTrigger = secondToCronTrigger("30");
        String expression = cronTrigger.getExpression();
        System.out.println(expression);
    }


}
