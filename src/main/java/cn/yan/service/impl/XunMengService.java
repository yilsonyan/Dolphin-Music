package cn.yan.service.impl;

import cn.yan.dao.RecordMapper;
import cn.yan.dao.SingerMapper;
import cn.yan.dao.SingerSongMapper;
import cn.yan.dao.SongMapper;
import cn.yan.entity.*;
import cn.yan.entity.custom.Songs;
import cn.yan.utils.XunMengUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class XunMengService {

    @Resource
    private RecordMapper recordMapper;
    @Resource
    private SingerMapper singerMapper;
    @Resource
    private SongMapper songMapper;
    @Resource
    private SingerSongMapper singerSongMapper;


    public void saveAllBySongName(String songName) {

        if (!"".equals(songName)) {

            List<List<Songs>> listAll = XunMengUtil.getResultList(songName);

            if (listAll != null) {
                for (List<Songs> list : listAll) {
                    if (list != null) {
                        for (Songs songs : list) {
                            //用自定义javaBean保存数据
                            Song song = XunMengUtil.saveSong(songs);
                            //保存唱片
                            Record record = XunMengUtil.saveRecord(songs);
                            //保存歌手
                            Singer singer = XunMengUtil.saveSinger(songs);
                            //保存中间键
                            List<SingerSong> singerSongList = XunMengUtil.saveSingerSong(songs);
                            if (song != null) {
                                Song song1 = songMapper.selectByPrimaryKey(song.getId());
                                if (song1 == null) {
                                    songMapper.insert(song);
                                    //保存中间健
                                    if (singerSongList != null) {
                                        for (SingerSong singerSong : singerSongList) {
                                            if (singerSong != null && singerSong.getSongId() == song.getId().intValue()) {
                                                //保存singerId
                                                SingerSongKey singerSongKey1 = singerSongMapper.selectBySingerId(singerSong);
                                                if (singerSongKey1 == null) {
                                                    singerSongMapper.insert(singerSong);
                                                }
                                            }
                                        }
                                    }

                                }
                            }

                            if (singer != null) {
                                Singer singer1 = singerMapper.selectByPrimaryKey(singer.getId());
                                if (singer1 == null) {
                                    singerMapper.insert(singer);
                                    //保存中间健
                                    if (singerSongList != null) {
                                        for (SingerSongKey singerSongKey : singerSongList) {
                                            if (singerSongKey != null && singerSongKey.getSingerId() == singer.getId().intValue()) {
                                                //保存songId
                                                SingerSong singerSong1= singerSongMapper.selectBySingerId(singerSongKey);
                                                if (singerSong1 == null) {
                                                    singerSongMapper.insert(singerSong1);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (record != null) {
                                Record record1 = recordMapper.selectByPrimaryKey(record.getId());
                                if (record1 == null) {
                                    recordMapper.insert(record);
                                }
                            }

                        }
                    }
                }

            }

        }

    }


}
