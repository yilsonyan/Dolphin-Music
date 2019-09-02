package cn.jd.char_string;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;

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
	 * Join拼接字符串
	 * 拼接字符串使用静态方法join()，它用指定的字符串连接字符串数组：
	 */
	@Test
	public void test1(){
		String[] arr = {"A", "B", "C"};
		String s = String.join("***", arr); // "A***B***C"
		System.out.println(s);
	}



	/**
	 * 测试StringJoiner
	 */
	@Test
	public void test4(){
		String[] names = {"Bob", "Alice", "Grace"};
		StringJoiner sj = new StringJoiner(",");
		for (String name : names) {
			sj.add(name);
		}
		System.out.println(sj.toString());


		String[] names2 = {"Bob", "Alice", "Grace"};
		StringJoiner sj2 = new StringJoiner(",", "Hello!", "!");//TODO 指定前缀后缀
		for (String name : names2) {
			sj2.add(name);
		}
		System.out.println(sj2.toString());
	}



	/**
	 * 转换编码
	 */
	@Test
	public void test3(){
		String tang = "tang";
		byte[] utf8s = tang.getBytes(StandardCharsets.UTF_8);
		String string = new String(utf8s);
		System.out.println(string);



		String str = new String();
		System.out.println(str);// String的默认值为""

		String str2;
		System.out.println(); //没有new时，创建的字符串为null
	}


	/**
	 * String.matches
	 * @throws Exception
	 */
	@Test
	public void test() throws Exception {
		String str1 = "My String";
		String str2 = new String ("My String");

		System.out.println(str1.matches(str2));  //不是正则表达式，则直接equals
		System.out.println(str1.hashCode() == str2.hashCode());;
	}



}
