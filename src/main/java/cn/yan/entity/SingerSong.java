package cn.yan.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

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
    private Integer singerId;

    /**
     * 歌曲id
     */
    private Integer songId;

    /**
     * 介绍
     */
    private String intro;

}