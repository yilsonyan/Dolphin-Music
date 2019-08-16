package cn.jd.Exception;

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
public class Exceptiontest {

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

}
