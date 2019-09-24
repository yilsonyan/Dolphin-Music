package cn.yan.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Record {
    private Integer id;
    private String commentThreadId;
    private String company;
    private String intro;
    private String name;
    private String picUrl;
    private Integer singerId;
    private Date publishTime;
}