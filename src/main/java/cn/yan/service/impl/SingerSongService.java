package cn.yan.service.impl;

import cn.yan.dao.SingerSongMapper;
import cn.yan.entity.SingerSong;
import cn.yan.service.ISingerSongService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class SingerSongService extends ServiceImpl<SingerSongMapper, SingerSong> implements ISingerSongService {

    @Resource
    private SingerSongMapper singerSongMapper;


}
