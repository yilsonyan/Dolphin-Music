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
 * 歌手列表
 */
@Data
public class Artists {

    private Long id;
    private String name;
    private List<String> alia;

}