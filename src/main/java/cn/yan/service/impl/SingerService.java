package cn.yan.service.impl;

import cn.yan.dao.SingerMapper;
import cn.yan.entity.Singer;
import cn.yan.service.ISingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SingerService implements ISingerService {

    @Autowired
    private SingerMapper singerMapper;

    @Override
    public void insertEntity(Singer entity) {
        if(entity!=null && entity.getId()!=null){
            singerMapper.insert(entity);
        }
    }


    public Singer selectEntityById(Integer id) {

        if(id!=null){
           return singerMapper.selectByPrimaryKey(id);
        }

        return null;
    }

    @Override
    public void updateEntityById(Singer entity) {

    }
}
