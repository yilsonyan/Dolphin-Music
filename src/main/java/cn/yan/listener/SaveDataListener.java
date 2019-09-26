package cn.yan.listener;

import cn.yan.service.IRecordService;
import cn.yan.service.ISingerService;
import cn.yan.service.ISingerSongService;
import cn.yan.service.ISongService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Date;

//@WebListener
//@Component
public class SaveDataListener implements ServletContextListener {
    private final static Logger logger = LoggerFactory.getLogger(SaveDataListener.class);

    @Autowired
    private ISongService songService;
    @Autowired
    private ISingerService singerService;
    @Autowired
    private ISingerSongService singerSongService;
    @Autowired
    private IRecordService recordService;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info(new Date() + "自定义监听器启动。。。");

        //获取spring容器内的上下文，拿到BaseService的Bean
        //songService = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext()).getBean(SongService.class);

        /*for (int i = 0; i < 10; i++) {
            List<Integer> listId = BaseUtil.getRandomNumber(1000, 10000, 1000);
            //song线程
            //SpiderSongRunnable spiderSongRunnable = new SpiderSongRunnable(songService, singerSongService, listId);
            SpiderSongRunnable spiderSongRunnable = new SpiderSongRunnable(listId);
            Thread songThread = new Thread(spiderSongRunnable);
            songThread.start();
            logger.info("song线程开启----------");

            SpiderSingerRunnable spiderSingerRunnable = new SpiderSingerRunnable(singerService, listId);
            Thread singerThread = new Thread(spiderSingerRunnable);
            singerThread.start();
            logger.info("singer线程开启----------");

            SpiderRecordRunnable spiderRecordRunnable = new SpiderRecordRunnable(recordService, listId);
            Thread recordThread = new Thread(spiderRecordRunnable);
            recordThread.start();
            logger.info("record线程开启-------");
        }*/

    }


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("自定义监听器销毁-------");
    }


}
