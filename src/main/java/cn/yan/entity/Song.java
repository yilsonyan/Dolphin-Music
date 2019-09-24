package cn.yan.entity;

import lombok.Data;

@Data
public class Song {
    private Long id;

    private String commentThreadId;

    private String mp3url;

    private String name;

    private Integer recordId;
}