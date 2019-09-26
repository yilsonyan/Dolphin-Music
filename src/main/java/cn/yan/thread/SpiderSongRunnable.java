package cn.yan.thread;

import cn.yan.entity.SingerSong;
import cn.yan.entity.Song;
import cn.yan.entity.custom2.Artists;
import cn.yan.entity.custom2.SongMsg;
import cn.yan.service.ISingerSongService;
import cn.yan.service.ISongService;
import cn.yan.spider.NetMusicGrab;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpiderSongRunnable implements Runnable {

    private ISongService songService;
    private ISingerSongService singerSongService;
    private List<Integer> listId;
    private final static Logger logger = LoggerFactory.getLogger(SpiderSongRunnable.class);

    public SpiderSongRunnable(ISongService songService, ISingerSongService singerSongService, List<Integer> listId){
        this.songService = songService;
        this.singerSongService = singerSongService;
        this.listId = listId;
    }


    @Override
    public void run() {
        logger.info(new Date()+Thread.currentThread().getName()+":..........线程开启");
        System.out.println("---------------");
        //插入音乐
        insertSong();
        logger.info(new Date()+Thread.currentThread().getName()+":....。。。..线程结束");
    }


    /**
     * 保存音乐与其singer_song中间表
     */
    private void insertSong() {
        if(listId!=null){
            for(Integer id:listId){
                String url = "https://music.163.com/artist?id="+id;
                String charest = "utf-8";
                List<SongMsg> list = NetMusicGrab.getSongList(url,charest);
                if(list!=null && list.size()>0){
                    for (SongMsg songMsg : list) {
                        Song song = new Song();
                        song.setId(songMsg.getId());
                        song.setName(songMsg.getName());
                        song.setCommentThreadId(songMsg.getCommentThreadId());
                        song.setRecordId((int) songMsg.getAlbum().getId());
                        logger.info(song.toString());
                        Song song1 = songService.getById(song.getId());
                        if(song1==null){
                            songService.save(song);
                        }
                        //插入中间表
                        List<Artists> artistsList = songMsg.getArtists();
                        List<SingerSong> singerSongList = new ArrayList<>();
                        String intro = "";
                        if(artistsList!=null && artistsList.size()>0){
                            for(Artists artists:artistsList){
                                SingerSong singerSong = new SingerSong();
                                singerSong.setSingerId(artists.getId());
                                singerSong.setSongId((int)songMsg.getId());
                                intro+=artists.getName()+"/";
                                SingerSong singerSong1 = singerSongService.getById(singerSong.getId());
                                if(singerSong1==null){
                                    singerSongList.add(singerSong);
//                                singerSongService.insertEntity(singerSong);
                                }
                            }
                        }
                        if(singerSongList.size()>0){
                            for(SingerSong singerSong:singerSongList){
                                singerSong.setIntro(intro);
                                SingerSong singerSong1 = singerSongService.getById(singerSong.getId());
                                if(singerSong1==null){
                                    singerSongService.save(singerSong);
                                }
                            }
                        }



                    }
                }
            }
        }
    }


}
