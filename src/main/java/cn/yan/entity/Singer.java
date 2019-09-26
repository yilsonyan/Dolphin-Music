package cn.yan.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 歌手
 */
@Data
@Accessors(chain = true)//链式setter
@EqualsAndHashCode(callSuper = false)//不比较父类属性
@Entity
public class Singer {
    @Id
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 介绍
     */
    private String intro;

    /**
     * 图片地址
     */
    private String picUrl;


}