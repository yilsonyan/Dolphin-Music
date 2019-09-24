package cn.yan.service;

import cn.yan.entity.Singer;

public interface ISingerService extends IBaseService<Singer> {


    Singer selectEntityById(Integer id);
}
