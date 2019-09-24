package cn.yan.service;

import cn.yan.entity.SingerSong;
import cn.yan.entity.SingerSongKey;

public interface ISingerSongService extends IBaseService<SingerSong> {

    public SingerSong selectEntityById(SingerSongKey singerSongKey);
}
