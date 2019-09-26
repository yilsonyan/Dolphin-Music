package cn.yan.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 歌曲
 */
@Data
@Accessors(chain = true)//链式setter
@EqualsAndHashCode(callSuper = false)//不比较父类属性
@Entity
public class Song {
    @Id
    private Long id;

    /**
     * 歌曲名
     */
    private String name;

    /**
     *
     */
    private String commentThreadId;

    /**
     * 链接地址
     */
    private String mp3url;

    /**
     * 记录id
     */
    private Integer recordId;


}