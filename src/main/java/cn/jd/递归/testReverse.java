package cn.jd.递归;

/**
 * 　　　 ┏━┓     ┏━┓
 * ┏┛ ┻━━━━━┛ ┻┓
 * ┃　　　　　　 ┃
 * ┃　　　━　　　┃
 * ┃　┳┛　  ┗┳　┃               高山仰止，景行行止，虽不能至，心向往之。
 * ┃　　　　　　 ┃               Codes are far away from bugs with the animal protecting.
 * ┃　　　┻　　　┃
 * ┃　　　　　　 ┃               * @Author：yilson
 * ┗━┓　　　┏━━━┛               * @Date:：2019-06-23 08:49
 * ┃　　　┃                   * @Description：
 * ┃　　　┃
 * ┃　　　┗━━━━━━━━━┓
 * ┃　　　　　　　    ┣┓
 * ┃　　　　         ┏┛
 * ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
 * ┃ ┫ ┫   ┃ ┫ ┫
 * ┗━┻━┛   ┗━┻━┛
 */
public class testReverse {


    public static void main(String[] args){
        System.out.println(sum(10));
        System.out.println(sum2(10));
    }


    //递归求和：10+9+8...
    public static int sum(int i){
        if(i==1){
            return 1;
        }
        return i+sum(i-1);
    }


    //递归求阶乘：10*9*8...
    public static int sum2(int i){
        if(i==1){
            return 1;
        }
        return i*sum2(i-1);
    }


}
