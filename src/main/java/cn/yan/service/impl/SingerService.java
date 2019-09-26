package cn.yan.service.impl;

import cn.yan.dao.SingerMapper;
import cn.yan.entity.Singer;
import cn.yan.service.ISingerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class SingerService extends ServiceImpl<SingerMapper, Singer> implements ISingerService {

    @Resource
    private SingerMapper singerMapper;



}
