/**
  * Copyright 2018 bejson.com 
  */
package cn.yan.entity.custom;
import lombok.Data;

import java.util.List;

/**
 * Auto-generated: 2018-06-06 20:59:46
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
public class Album {

    private String name;
    private int id;
    private String type;
    private int size;
    private long picId;
    private String blurPicUrl;
    private int companyId;
    private long pic;
    private String picUrl;
    private long publishTime;
    private String description;
    private String tags;
    private String company;
    private String briefDesc;
    private Artist artist;
    private List<String> songs;
    private List<String> alias;
    private int status;
    private int copyrightId;
    private String commentThreadId;
    private List<Artists> artists;
    private String picId_str;

}