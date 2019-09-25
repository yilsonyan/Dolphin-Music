package cn.yan.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@Data
public class User extends Model<User> {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
