/**
  * Copyright 2018 bejson.com 
  */
package cn.yan.entity.netmusic;

import lombok.Data;

import java.util.List;

/**
 * Auto-generated: 2018-06-10 20:8:39
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */

/**
 * 爬取到的歌曲信息
 */
@Data
public class SongMsg {

    private int publishTime;
    private int fee;
    private int ftype;
    private int no;
    private List<String> alias;
    private Privilege privilege;
    private int djid;
    private Album album;
    private List<Artists> artists;
    private int score;
    private int copyrightId;
    private long mvid;
//    private String transNames;
    private String commentThreadId;
    private int type;
    private long duration;
    private int status;
    private String name;
    private long id;

}