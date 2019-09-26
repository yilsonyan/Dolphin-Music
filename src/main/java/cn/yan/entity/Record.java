package cn.yan.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 日志
 */
@Data
@Accessors(chain = true)//链式setter
@EqualsAndHashCode(callSuper = false)//不比较父类属性
@Entity
public class Record {
    @Id
    private Integer id;

    /**
     *
     */
    private String commentThreadId;

    /**
     * 公司
     */
    private String company;

    /**
     * 专辑介绍
     */
    private String intro;

    /**
     * 专辑名称
     */
    private String name;

    /**
     * 图片地址
     */
    private String picUrl;

    /**
     * 歌手id
     */
    private Integer singerId;

    /**
     * 发行时间
     */
    private Date publishTime;


}