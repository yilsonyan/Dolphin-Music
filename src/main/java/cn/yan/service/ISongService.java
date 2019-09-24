package cn.yan.service;

import cn.yan.entity.Song;

public interface ISongService extends IBaseService<Song> {

    public Song selectEntityById(Long id);



}
