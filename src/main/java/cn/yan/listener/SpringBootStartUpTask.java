package cn.yan.listener;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * SpringBoot容器加载后自动监听
 *
 * @author yanbinyuan
 * @version jdk1.8
 * @date 2019年7月1日
 */
@Component
public class SpringBootStartUpTask implements CommandLineRunner {

    //日志
    private final Logger logger = LoggerFactory.getLogger(SpringBootStartUpTask.class);

    /**
     * run方法指定项目启动后指定执行的任务
     *
     * @param args
     */
    @Override
    public void run(String... args) {
        try {
            //Runtime.getRuntime().exec("cmd   /c   start   http://localhost:8080");
            logger.info("SpringBoot启动成功----------");

            //for (int i = 0; i < 10; i++) {
                /*List<Long> listId = BaseUtil.getRandomNumber(1000, 10000, 1000);
                //song线程
                SpiderSongRunnable spiderSongRunnable = new SpiderSongRunnable(listId);
                Thread songThread = new Thread(spiderSongRunnable,"song线程");
                songThread.start();
                logger.info("song线程开启----------");

                SpiderSingerRunnable spiderSingerRunnable = new SpiderSingerRunnable(listId);
                Thread singerThread = new Thread(spiderSingerRunnable,"singer线程");
                singerThread.start();
                logger.info("singer线程开启----------");

                SpiderRecordRunnable spiderRecordRunnable = new SpiderRecordRunnable(listId);
                Thread recordThread = new Thread(spiderRecordRunnable,"record线程");
                recordThread.start();
                logger.info("record线程开启-------");*/
            //}

        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("启动初始化任务异常！{}", ex.getMessage());
        }
    }

}