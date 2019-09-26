package cn.yan.thread;

import cn.yan.entity.Record;
import cn.yan.service.IRecordService;
import cn.yan.spider.NetMusicGrab;
import cn.yan.util.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SpiderRecordRunnable implements Runnable {
    private final static Logger logger = LoggerFactory.getLogger(SpiderRecordRunnable.class);

    private IRecordService recordService = SpringContextUtil.getBean(IRecordService.class);

    private List<Long> listId;
    public SpiderRecordRunnable(List<Long> listId) {
        this.listId = listId;
    }


    @Override
    public void run() {
        logger.info(Thread.currentThread().getName() + "----------线程开启");
        getRecords();//获取专辑
        logger.info(Thread.currentThread().getName() + "----------线程结束");
    }

    /**
     * 获取专辑
     */
    private void getRecords() {
        if (listId != null) {
            for (Long singerId : listId) {
                String url = "https://music.163.com/artist/album?id=" + singerId + "&limit=100&offset=0";
                List<Record> list = NetMusicGrab.getRecordList(url, "utf-8");
                saveRecords(singerId, list);
            }
        }
    }

    /**
     * 保存专辑
     */
    private void saveRecords(Long singerId,  List<Record> list){
        if (list == null || list.size() == 0){
            return;
        }
        for (Record record : list) {
            if (record != null && record.getId() != null) {
                //设置歌手id
                record.setSingerId(singerId);
                recordService.saveOrUpdate(record);
            }
        }
    }




}
