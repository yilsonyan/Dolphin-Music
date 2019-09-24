package cn.yan.service.impl;

import cn.yan.dao.RecordMapper;
import cn.yan.entity.Record;
import cn.yan.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService implements IRecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public void insertEntity(Record entity) {
        if(entity!=null && entity.getId()!=null){
            recordMapper.insert(entity);
        }

    }


    @Override
    public void updateEntityById(Record entity) {

    }

    @Override
    public Record selectEntityById(Integer id) {
        if(id!=null){
           return recordMapper.selectByPrimaryKey(id);
        }

        return null;
    }
}
