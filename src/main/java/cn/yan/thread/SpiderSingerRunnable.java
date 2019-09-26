package cn.yan.thread;

import cn.yan.entity.Singer;
import cn.yan.service.ISingerService;
import cn.yan.spider.NetMusicGrab;
import cn.yan.util.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SpiderSingerRunnable implements Runnable {
    private final static Logger logger = LoggerFactory.getLogger(SpiderSingerRunnable.class);

    private ISingerService singerService = SpringContextUtil.getBean(ISingerService.class);

    private List<Long> listId;
    public SpiderSingerRunnable(List<Long> listId) {
        this.listId = listId;
    }

    @Override
    public void run() {
        logger.info(Thread.currentThread().getName() + "----------线程开启");
        insertSinger();//插入音乐
        logger.info(Thread.currentThread().getName() + "----------线程结束");
    }

    private void insertSinger() {
        if (listId != null) {
            for (Long id : listId) {
                String url = "https://music.163.com/artist/desc?id=" + id;
                Singer singer = NetMusicGrab.getSinger(url, "utf-8");

                if (singer != null) {
                    //设置歌手id为desc?id=的参数
                    singer.setId(id);
                    singerService.saveOrUpdate(singer);
                }
            }
        }
    }



}

