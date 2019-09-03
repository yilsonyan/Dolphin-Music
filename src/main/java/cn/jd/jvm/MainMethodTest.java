package cn.jd.jvm;

public class MainMethodTest {


	//然后，执行：java MainMethodTest -version
	public static void main(String[] args) {
		for (String arg : args) {
			if ("-version".equals(arg)) {
				System.out.println("v 1.0");
				break;
			}
		}
	}


}
