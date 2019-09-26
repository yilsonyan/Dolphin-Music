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
public class Songs {

    private String name;
    private long id;
    private int position;
    private List<String> alias;
    private int status;
    private int fee;
    private int copyrightId;
    private String disc;
    private int no;
    private List<Artists> artists;
    private Album album;
    private boolean starred;
    private int popularity;
    private int score;
    private int starredNum;
    private long duration;
    private int playedNum;
    private int dayPlays;
    private int hearTime;
    private String ringtone;
    private String crbt;
    private String audition;
    private String copyFrom;
    private String commentThreadId;
    private String rtUrl;
    private int ftype;
    private List<String> rtUrls;
    private int copyright;
    private String mp3Url;
    private int rtype;
    private String rurl;
    private long mvid;

}