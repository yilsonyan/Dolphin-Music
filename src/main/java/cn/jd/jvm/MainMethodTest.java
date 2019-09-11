package cn.jd.jvm;

public class MainMethodTest {


	//然后到cn.jd.jvm的上层目录，执行：java cn.jd.jvm.MainMethodTest -version
	public static void main(String[] args) {
		for (String arg : args) {
			if ("-version".equals(arg)) {
				System.out.println("v 1.0");
				break;
			}
		}
	}


}
