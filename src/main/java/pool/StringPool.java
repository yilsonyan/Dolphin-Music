package pool;

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
# 　　　　┃　　　　          ┏┛          * @Date:：2019-03-18 19:17
# 　　　　┗┓┓┏━┳┓┏┛              * @Description：
# 　　　　  ┃┫┫　┃┫┫
# 　　　　 ┗┻┛   ┗┻┛
*/
public class StringPool {
    public static void main(String[] args) {
        String s1 = new String("1");
        String s2 = new String("1");
        System.out.println(s1.hashCode());// 49
        System.out.println(s2.hashCode());// 49
        System.out.println(s1 == s2);// false
        System.out.println(s1.equals(s2));// true

        System.out.println("-------------------");

        String s3 = "1";
        String s4 = "1";
        System.out.println(s3 == s4);// true
        System.out.println(s3.equals(s4));// true
        System.out.println(s3.hashCode());// 49
        System.out.println(s4.hashCode());// 49

        char c = '中';
        System.out.println(c);


    }
}
