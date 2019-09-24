package cn.yan.dao;

import cn.yan.entity.SingerSong;
import cn.yan.entity.SingerSongExample;
import cn.yan.entity.SingerSongKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SingerSongMapper {
    int countByExample(SingerSongExample example);

    int deleteByExample(SingerSongExample example);

    int deleteByPrimaryKey(SingerSongKey key);

    int insert(SingerSong record);

    int insertSelective(SingerSong record);

    List<SingerSong> selectByExample(SingerSongExample example);

    SingerSong selectByPrimaryKey(SingerSongKey key);

    int updateByExampleSelective(@Param("record") SingerSong record, @Param("example") SingerSongExample example);

    int updateByExample(@Param("record") SingerSong record, @Param("example") SingerSongExample example);

    int updateByPrimaryKeySelective(SingerSong record);

    int updateByPrimaryKey(SingerSong record);

    SingerSong selectBySingerId(SingerSongKey singerSongKey);
}