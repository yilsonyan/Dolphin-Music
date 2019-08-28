package cn.jd.jvm;

import javax.validation.constraints.NotNull;

public class MainMethodTest {


	//然后，执行：java MainMethodTest -version
	public static void main(@NotNull String[] args) {
		for (String arg : args) {
			if ("-version".equals(arg)) {
				System.out.println("v 1.0");
				break;
			}
		}
	}


}
