package cn.yan.listener;

import cn.yan.service.IRecordService;
import cn.yan.service.ISingerService;
import cn.yan.service.ISingerSongService;
import cn.yan.service.ISongService;
import cn.yan.service.impl.SongService;
import cn.yan.thread.SpiderRecordRunnable;
import cn.yan.thread.SpiderSingerRunnable;
import cn.yan.thread.SpiderSongRunnable;
import cn.yan.utils.BaseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Date;
import java.util.List;

@WebListener
@Component
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
        logger.info(new Date()+"自定义监听器启动。。。");
        System.out.println("自定义监听器启动。。。");

        //获取spring容器内的上下文，拿到BaseService的Bean
        songService = WebApplicationContextUtils
                         .getWebApplicationContext(servletContextEvent.getServletContext()).getBean(SongService.class);


        for(int i=0;i<10;i++){
            List<Integer> listId = BaseUtil.getRandomNumber(1000,10000,1000);
            //song线程
            SpiderSongRunnable spiderSongRunnable = new SpiderSongRunnable(songService,
                                singerSongService,listId);

            Thread songThread = new Thread(spiderSongRunnable);
            songThread.start();
            //singer线程
            logger.info(new Date()+"singer线程开启-------");
            SpiderSingerRunnable spiderSingerRunnable = new SpiderSingerRunnable(singerService,listId);
            Thread singerThread = new Thread(spiderSingerRunnable);
            singerThread.start();
            //record线程
            logger.info("record线程开启-------");
            SpiderRecordRunnable spiderRecordRunnable = new SpiderRecordRunnable(recordService,listId);
            Thread recordThread = new Thread(spiderRecordRunnable);
            recordThread.start();
        }

    }


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("自定义监听器销毁。。。");
        System.out.println("自定义监听器销毁。。。");
    }

}
