package cn.yan.service.impl;

import cn.yan.dao.SongMapper;
import cn.yan.entity.Song;
import cn.yan.service.ISongService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class SongService extends ServiceImpl<SongMapper, Song>  implements ISongService {

    @Resource
    private SongMapper songMapper;







}
