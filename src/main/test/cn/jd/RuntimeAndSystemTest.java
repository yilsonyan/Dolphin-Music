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

		String commands = "ifconfig";
		Process proc = Runtime.getRuntime().exec(commands);

		//获取流
		InputStream in = proc.getInputStream();
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);

		//输出命令结果
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
	public void testOSCommand() throws Exception {
		Properties properties = System.getProperties();

		String property = System.getProperty("os.name");
		String lowerCase = property.toLowerCase();

		if (lowerCase.contains("windows")){
			String cmd = "notepad.exe";
			Process process = Runtime.getRuntime().exec(cmd);
			//Dll instance = (Dll) Native.loadLibrary("Dll1", Dll.class);


		}else if (lowerCase.contains("mac")){
			String cmd = "open /Applications/iTunes.app";
			Process process = Runtime.getRuntime().exec(cmd);


		}else if (lowerCase.contains("linux")){
			String cmd = "open /Applications/iTunes.app";
			Process process = Runtime.getRuntime().exec(cmd);
		}


	}




}