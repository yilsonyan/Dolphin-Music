package cn.jd.overload_override;

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
# 　　　　┃　　　　          ┏┛          * @Date:：2019-03-19 07:54
# 　　　　┗┓┓┏━┳┓┏┛              * @Description：
# 　　　　  ┃┫┫　┃┫┫
# 　　　　 ┗┻┛   ┗┻┛
*/
//重载
public class Overload {


    @Test
    public void test1(){
        show(1,2,3);
    }


    //可变参
    public void show(int...ints){
        for (int Int : ints) {
            System.out.println(Int);
        }
    }


    public void show(String msg){
        System.out.println(msg);
    }

    /**
     * 重载与返回值类型、形参名无关，编译报错
     */
    //public String show(String sth){

    //}

    public void show(String name,String msg){
        System.out.println(name+msg);
    }
}
