package cn.yan.thread;

import cn.yan.entity.SingerSong;
import cn.yan.entity.Song;
import cn.yan.entity.netmusic.Artists;
import cn.yan.entity.netmusic.SongMsg;
import cn.yan.service.ISingerSongService;
import cn.yan.service.ISongService;
import cn.yan.spider.NetMusicGrab;
import cn.yan.util.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SpiderSongRunnable implements Runnable {
    private final static Logger logger = LoggerFactory.getLogger(SpiderSongRunnable.class);

    private ISongService songService = SpringContextUtil.getBean(ISongService.class);
    private ISingerSongService singerSongService = SpringContextUtil.getBean(ISingerSongService.class);

    /**
     * 歌曲id
     */
    private List<Integer> listId;
    public SpiderSongRunnable(List listId) {
        this.listId = listId;
    }

    @Override
    public void run() {
        logger.info(Thread.currentThread().getName() + "----------线程开启");
        getSongList();//获取音乐
        logger.info(Thread.currentThread().getName() + "----------线程结束");
    }



    /**
     * 获取音乐信息
     */
    private void getSongList() {
        if (listId != null) {
            for (Integer id : listId) {
                try {
                    Thread.sleep(1000 * 5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String url = "https://music.163.com/artist?id=" + id;
                List<SongMsg> list = NetMusicGrab.getSongList(url, "utf-8");
                saveSongAndSingerSong(list);

                //界面展示


            }
        }
    }



    /**
     * 保存音乐与其SingerSong中间表
     */
    private void saveSongAndSingerSong(List<SongMsg> list){
        if (list == null || list.size() == 0){
            return;
        }
        for (SongMsg songMsg : list) {
            //保存歌曲
            Song song = new Song();
            song.setId(songMsg.getId())
                .setName(songMsg.getName())
                .setCommentThreadId(songMsg.getCommentThreadId())
                .setRecordId((int) songMsg.getAlbum().getId());
            songService.saveOrUpdate(song);

            //插入中间表
            //获取歌手列表
            List<Artists> artistsList = songMsg.getArtists();
            List<SingerSong> singerSongList = new ArrayList<>();

            //介绍，用于一次查找歌曲的所有歌手
            String intro = "";
            //遍历歌手列表
            if (artistsList != null && artistsList.size() > 0) {
                for (int i = 0; i < artistsList.size(); i++) {
                    Artists artists = artistsList.get(i);
                    SingerSong singerSong = new SingerSong();
                    singerSong.setSingerId(artists.getId()).setSongId(songMsg.getId());

                    if (i > 0){
                        //歌手
                        intro += "/" + artists.getName();
                    }
                    singerSongList.add(singerSong);
                }
            }

            //添加介绍信息并保存
            for (SingerSong singerSong : singerSongList) {
                singerSong.setIntro(intro);
                singerSongService.saveOrUpdate(singerSong);
            }

        }
    }

}
