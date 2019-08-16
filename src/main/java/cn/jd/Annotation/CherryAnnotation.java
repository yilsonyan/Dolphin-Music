package cn.jd.Annotation;


import java.lang.annotation.*;


@Target(value = {ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})//作用在哪些地方
@Retention(RetentionPolicy.RUNTIME)//生命周期：1、Java源文件阶段；2、编译到class文件阶段；3、运行期阶段。
@Documented//生成到JavaDoc文档当中
@Inherited//可被继承，只对那些@Target被定义为ElementType.TYPE的自定义注解起作用。
public @interface CherryAnnotation {

    public String name();

    int age() default 18;

    int[] score();


}
