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
# 　　　　┃　　　　          ┏┛          * @Date:：2019-03-18 18:16
# 　　　　┗┓┓┏━┳┓┏┛              * @Description：
# 　　　　  ┃┫┫　┃┫┫
# 　　　　 ┗┻┛   ┗┻┛
*/
public class IntegerPoll {

        public static void main(String[] args) {
            Integer i1 = new Integer(1);
            Integer i2 = new Integer(1);
            System.out.println(i1.hashCode());
            System.out.println(i2.hashCode());
            System.out.println(i1 == i2);
            System.out.println(i1.equals(i2));

            System.out.println("-------------------");

            Integer i3 = 1;
            Integer i4 = 1;
            System.out.println(i3.hashCode());
            System.out.println(i4.hashCode());
            System.out.println(i3 == i4);
            System.out.println(i3.equals(i4));

        }

}
