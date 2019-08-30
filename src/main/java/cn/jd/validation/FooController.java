package cn.jd.validation;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * JSR提供的校验注解：
 *
 * @Null 被注释的元素必须为 null
 * @NotNull 被注释的元素必须不为 null
 * @AssertTrue 被注释的元素必须为 true
 * @AssertFalse 被注释的元素必须为 false
 * @Min(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 * @Max(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 * @DecimalMin(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 * @DecimalMax(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 * @Size(max=, min=)   被注释的元素的大小必须在指定的范围内
 * @Digits (integer, fraction)     被注释的元素必须是一个数字，其值必须在可接受的范围内
 * @Past 被注释的元素必须是一个过去的日期
 * @Future 被注释的元素必须是一个将来的日期
 * @Pattern(regex=,flag=) 被注释的元素必须符合指定的正则表达式
 * <p>
 * <p>
 * Hibernate Validator提供的校验注解：
 * @NotBlank(message =)   验证字符串非null，且长度必须大于0
 * @Email 被注释的元素必须是电子邮箱地址
 * @Length(min=,max=) 被注释的字符串的大小必须在指定的范围内
 * @NotEmpty 被注释的字符串的必须非空
 * @Range(min=,max=,message=) 被注释的元素必须在合适的范围内
 * ————————————————
 * 原文链接：https://blog.csdn.net/u013815546/article/details/77248003
 */
@RestController
@Validated
public class FooController {


    /**
     * 值得注意的地方：
     *
     * <1> 参数Foo前需要加上@Validated注解，表明spring对其进行校验，校验信息会放到其后的BindingResult中。
     * 注意，必须相邻，如果有多个参数需要校验，形式可以如下：
     * foo(@Validated Foo foo, BindingResult fooBindingResult ，@Validated Bar bar, BindingResult barBindingResult);
     *
     * <2> 校验结果bindingResult会被自动填充，在controller中可根据业务决定具体的操作，如跳转到错误页面。
     */
    @RequestMapping("/foo") // http://localhost:8080/foo?name=xujingfeng&email=000&age=17
    public String foo(@Valid Foo foo, BindingResult bindingResult) {
        /*if (bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                String defaultMessage = fieldError.getDefaultMessage();
                sb.append(defaultMessage + "！");
            }
            return sb.toString();
        }
        return foo.toString();*/

        return foo.toString();
    }


    @RequestMapping("/foo2") // http://localhost:8080/foo2?name=xujingfeng&email=000&age=17
    public String foo2(@Validated Foo foo) {
        return "success";
    }

}