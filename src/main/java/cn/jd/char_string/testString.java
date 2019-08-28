package cn.jd.char_string;

import org.junit.Test;

/**
 * // 　　　 ┏━┓     ┏━┓
 * //      ┏┛ ┻━━━━━┛ ┻┓
 * //      ┃　　　　　　 ┃
 * //      ┃　　　━　　　┃
 * //      ┃　┳┛　  ┗┳　┃               高山仰止，景行行止，虽不能至，心向往之。
 * //      ┃　　　　　　 ┃               Codes are far away from bugs with the animal protecting.
 * //      ┃　　　┻　　　┃
 * //      ┃　　　　　　 ┃               * @Author：yilson
 * //      ┗━┓　　　┏━━━┛               * @Date:：2019-06-22 17:56
 * //        ┃　　　┃                   * @Description：
 * //        ┃　　　┃
 * //        ┃　　　┗━━━━━━━━━┓
 * //        ┃　　　　　　　    ┣┓
 * //        ┃　　　　         ┏┛
 * //        ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
 * //          ┃ ┫ ┫   ┃ ┫ ┫
 * //          ┗━┻━┛   ┗━┻━┛
 */
public class testString {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("1=1");
        sb.append(" and mallid =" + 1);
        System.out.println(sb);



        String a="";
        String b="";
        System.out.println(a == b);  //true
        System.out.println(a.equals(b));  //true
    }

	/**
	 * 拼接字符串
	 * 拼接字符串使用静态方法join()，它用指定的字符串连接字符串数组：
	 */
	@Test
	public void test1(){
		String[] arr = {"A", "B", "C"};
		String s = String.join("***", arr); // "A***B***C"
		System.out.println(s);
	}





}
