package cn.jd;

import cn.jd.login.controller.LoginController;
import cn.jd.login.controller.Splash;
import cn.jd.login.stage.LoginStage;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@EnableAsync
public class App extends AbstractJavaFxApplicationSupport {

	static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
		//showSplash();
		Splash splash = new Splash();
		launch(App.class,LoginController.class,args);//springboot-javafx-support启动方式
	    //App.showView(RegisterController.class);
    }

	/**
	 * 初始化构建主界面
	 */
	@Override
	public void start(Stage primaryStage) {
		LoginStage loginStage = new LoginStage();
		LoginController.loginStage = loginStage;
	}

	/**
	 * 启动动画
	 */
	public static void showSplash() {
		//用于运行SplashScreen的线程
		new Thread(()->{
			try{

			}catch(Exception e){
				e.printStackTrace();
			}
		}).start();
	}

	/*@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
	}*/

}
