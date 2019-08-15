package reflect;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 *  ┏━┓     ┏━┓
 * ┏┛ ┻━━━━━┛ ┻┓
 * ┃　　　　　　 ┃
 * ┃　　　━　　　┃
 * ┃　┳┛　  ┗┳　┃               高山仰止，景行行止，虽不能至，心向往之。
 * ┃　　　　　　 ┃               Codes are far away from bugs with the animal protecting.
 * ┃　　　┻　　　┃
 * ┃　　　　　　 ┃               * @Author：yilson
 * ┗━┓　　　┏━━━┛               * @Date:：2019-06-23 21:45
 *   ┃　　　┃                   * @Description：
 *   ┃　　　┃
 *   ┃　　　┗━━━━━━━━━┓
 *   ┃　　　　　　　    ┣┓
 *   ┃　　　　         ┏┛
 *   ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
 *     ┃ ┫ ┫   ┃ ┫ ┫
 *     ┗━┻━┛   ┗━┻━┛
 */
public class testAnno {

    //注解测试
    @Test
    public void test1() throws Exception {

        Method test1 = this.getClass().getDeclaredMethod("test1", null);

        //反射得出此方法是否有 Test 注解
        boolean present = test1.isAnnotationPresent(Test.class);
        System.out.println(present);

        Test test1Annotation = test1.getAnnotation(Test.class);
        System.out.println(test1Annotation);
    }







}
