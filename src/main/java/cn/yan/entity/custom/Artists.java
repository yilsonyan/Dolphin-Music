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
public class Artists {

    private String name;
    private Long id;
    private Long picId;
    private int img1v1Id;
    private String briefDesc;
    private String picUrl;
    private String img1v1Url;
    private int albumSize;
    private List<String> alias;
    private String trans;
    private int musicSize;

}