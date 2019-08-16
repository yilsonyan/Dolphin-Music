package cn.jd.reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * // 　　　 ┏━┓     ┏━┓
 * //      ┏┛ ┻━━━━━┛ ┻┓
 * //      ┃　　　　　　 ┃
 * //      ┃　　　━　　　┃
 * //      ┃　┳┛　  ┗┳　┃               高山仰止，景行行止，虽不能至，心向往之。
 * //      ┃　　　　　　 ┃               Codes are far away from bugs with the animal protecting.
 * //      ┃　　　┻　　　┃
 * //      ┃　　　　　　 ┃               * @Author：yilson
 * //      ┗━┓　　　┏━━━┛               * @Date:：2019-06-13 19:05
 * //        ┃　　　┃                   * @Description：
 * //        ┃　　　┃
 * //        ┃　　　┗━━━━━━━━━┓
 * //        ┃　　　　　　　    ┣┓
 * //        ┃　　　　         ┏┛
 * //        ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
 * //          ┃ ┫ ┫   ┃ ┫ ┫
 * //          ┗━┻━┛   ┗━┻━┛
 */
@SuppressWarnings("all")
public class TestReflect {


    //反射获取属性
    @Test
    public void testGetT() throws Exception {
        Person person1 = new Person();
        person1.setName("tangli");
        person1.setAge(24);

        Class<? extends Person> personZ = person1.getClass();

        Field name = personZ.getDeclaredField("name");
        //执行前暴力反射
        name.setAccessible(true);
        Object o = name.get(person1);


        System.out.println(o);
    }



    //反射执行方法
    @Test
    public void testInvoke() throws Exception {
        Person person1 = new Person();
        person1.setName("tangli");
        person1.setAge(24);

        Class<? extends Person> personZ = person1.getClass();


        Method loveSb = personZ.getDeclaredMethod("loveSb", null);
        //执行前暴力反射
        loveSb.setAccessible(true);
        Object invoke = loveSb.invoke(person1);

        System.out.println(invoke);
    }




}
