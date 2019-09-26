package cn.yan.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 歌手-歌曲中间表
 */
@Data
@Accessors(chain = true)//链式setter
@EqualsAndHashCode(callSuper = false)//不比较父类属性
@Entity
public class SingerSong {
    @Id
    private Long id;

    /**
     * 歌手id
     */
    private Long singerId;

    /**
     * 歌曲id
     */
    private Long songId;

    /**
     * 介绍
     */
    private String intro;

}