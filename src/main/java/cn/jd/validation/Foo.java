package cn.jd.validation;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 只需要引入spring-boot-starter-web依赖即可，如果查看其子依赖，可以发现如下的依赖：
 *
 * <dependency>
 *     <groupId>org.hibernate</groupId>
 *     <artifactId>hibernate-validator</artifactId>
 * </dependency>
 * <dependency>
 *     <groupId>com.fasterxml.jackson.core</groupId>
 *     <artifactId>jackson-databind</artifactId>
 * </dependency>
 */
@Data
public class Foo {


		@NotBlank
		private String name;

		@Min(18)
		private Integer age;

		@Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号码格式错误")
		@NotBlank(message = "手机号码不能为空")
		private String phone;

		@Email(message = "邮箱格式错误")
		private String email;

		//... getter setter

}
