package cn.yan;

import cn.yan.login.controller.LoginController;
import cn.yan.login.controller.Splash;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
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
		launch(App.class, LoginController.class, new Splash(), args);//springboot-javafx-support启动方式
	    logger.info("启动成功");
    }

	/**
	 * 初始化构建主界面
	 */
	/*@Override
	public void start(Stage primaryStage) {
		LoginStage loginStage = new LoginStage();
		LoginController.loginStage = loginStage;
	}*/


	/*@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
	}*/

}
