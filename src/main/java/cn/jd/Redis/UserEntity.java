package cn.jd.Redis;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserEntity implements Serializable {
    private Long id;
    private String guid;
    private String name;
    private String age;
    private Date createTime;
}