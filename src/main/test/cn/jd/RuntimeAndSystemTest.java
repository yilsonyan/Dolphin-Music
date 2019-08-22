package cn.jd;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

//@cn.jd.SpringBootTest(classes= PosApp.class,webEnvironment = cn.jd.SpringBootTest.WebEnvironment.DEFINED_PORT)
//@RunWith(SpringRunner.class)
//@EnableWebSocket
//@EnableAutoConfiguration
public class RuntimeAndSystemTest {


	@Test
	public void testIfconfig() throws Exception {
		Runtime runtime = Runtime.getRuntime();

		//String commands = "ifconfig";
		String commands = "os info";
		Process proc = runtime.exec(commands);

		InputStream in = proc.getInputStream();
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);

		String line = null;

		while ((line = br.readLine()) != null){
			System.out.println(line);
		}

		int exitVal = proc.waitFor();
		System.out.println("Process exitValue: " + exitVal);
	}


	@Test
	public void testOpenFile() throws Exception {
		Properties properties = System.getProperties();

		String userDir = System.getProperty("user.dir");
		File dir = new File(userDir);
		
		String s = "open "+ dir.toString();
		Process p = Runtime.getRuntime().exec(s);
	}

	@Test
	public void testOS() throws Exception {
		String property = System.getProperty("os.name");
		boolean windows = property.toLowerCase().contains("windows");
		if (windows){

		}
	}



	/*final static Logger log = Logger.getGlobal();

	static {
		try {
			//此处即为本地方法所在链接库名
			System.load("/libsysutil.so");

			log.info("加载libsysutil.so：成功!");
		} catch (UnsatisfiedLinkError e) {

			log.severe("无法加载库：" + e.toString());
		}
	}


	public static native String ExcuteCmd(String strCmd);*/

}