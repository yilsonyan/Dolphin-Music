package cn.yan.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.function.Function;

@Data
@Accessors(chain = true)//链式setter
@EqualsAndHashCode(callSuper = false)//不比较父类属性
@Entity
public class User extends Model<User> {
    @Id
    private Long id;
    private String name;
    private Integer age;
    private String email;

    public static void main(String[] args) {
        Function<User, String> name = User::getName;
        String toString = name.toString();
        System.out.println(name);
        System.out.println(toString);
    }



}
