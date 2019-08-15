package Annotation;


import java.lang.reflect.Method;

public class CherryAnnotationTest{

    @CherryAnnotation(name = "cherry-peng",age = 23,score = {99,66,77})
    public void study(int times){
        for(int i = 0; i < times; i++){
            System.out.println("Good Good Study, Day Day Up!");
        }
    }


    public static void main(String[] args) {
        try {
            //获取到方法
            Class<CherryAnnotationTest> clazz = CherryAnnotationTest.class;
            Method study = clazz.getMethod("study", int.class);

            //判断此方法是否标记指定注解
            boolean present = study.isAnnotationPresent(CherryAnnotation.class);
            if (present){
                //获取注解
                CherryAnnotation cherryAnnotation = study.getAnnotation(CherryAnnotation.class);
                String name = cherryAnnotation.name();
                int age = cherryAnnotation.age();
                int[] score = cherryAnnotation.score();

                System.out.println("名称："+name);
                System.out.println("年龄："+age);
                System.out.println("分数："+score);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
