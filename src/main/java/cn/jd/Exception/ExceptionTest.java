package cn.jd.Exception;

import org.junit.Test;

/*
# 　　　 ┏┓　      ┏┓
# 　　┏┛┻━━━┛┻┓
# 　　┃　　　━　　   ┃
# 　   ┃　┳┛　┗┳　┃
# 　　┃　　　　　　   ┃
# 　　┃　　　┻　　   ┃
# 　　┗━┓　　　┏━┛          Codes are far away from bugs with the animal protecting.
# 　　　　┃　　　┃                          高山仰止，景行行止，虽不能至，心向往之。
# 　　　　┃　　　┗━━━━┓           
# 　　　　┃　　　　　        ┣┓         * @Author：vincent
# 　　　　┃　　　　          ┏┛          * @Date:：2019-03-19 20:48
# 　　　　┗┓┓┏━┳┓┏┛              * @Description：
# 　　　　  ┃┫┫　┃┫┫
# 　　　　 ┗┻┛   ┗┻┛
*/
public class ExceptionTest {

    /**
     * 异常子类必须写在前面
     */
    public static void main(String[] args) {
        int a=10;
        int b=0;

        try {
            int i = a / b;
        } catch (Exception e) {   //最上面抓取大异常，小的异常就已经被抓取，进不去，编译时异常。
            e.printStackTrace();
        /*} catch (ArithmeticException e) {
            e.printStackTrace();*/
        } finally {
            System.out.println("finally...");
        }
    }

    /**
     * 异常屏蔽
     * finally语句时抛出异常，原来在catch中准备抛出的异常就“消失”了，因为只能抛出一个异常。
     * 没有被抛出的异常称为“被屏蔽”的异常（Suppressed Exception）。
     * 极少数的情况下，我们需要获知所有的异常。
     * 方法是先用origin变量保存原始异常，然后调用Throwable.addSuppressed()，把原始异常添加进来，最后在finally抛出：
     */
    @Test
    public void suppressed() throws Exception {
        Exception origin = null;
        try {
            System.out.println(Integer.parseInt("abc"));
        } catch (Exception orig) {
            origin = orig;
            throw origin;
        } finally {
            Exception e = new IllegalArgumentException();
            if (origin != null) {
                e.addSuppressed(origin);
            }
            throw e;
        }
    }



    /**
     * JVM默认关闭断言指令，即自动忽略了
     * 要执行assert语句，必须给Java虚拟机传递-enableassertions（可简写为-ea）参数启用断言。
     */
    @Test
    public void assertTest() throws Exception {
        int x = -1;
        assert x > 0 : "x must gt 0";
        System.out.println(x);
    }





}
