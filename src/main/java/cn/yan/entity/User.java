package cn.yan.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class User extends Model<User> {
    @Id
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
