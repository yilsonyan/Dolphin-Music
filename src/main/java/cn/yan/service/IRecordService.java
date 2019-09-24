package cn.yan.service;

import cn.yan.entity.Record;

public interface IRecordService extends IBaseService<Record> {

    public Record selectEntityById(Integer id);


}
