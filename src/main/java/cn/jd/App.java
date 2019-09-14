package cn.jd;

import cn.jd.login.controller.LoginController;
import cn.jd.login.controller.Splash;
import cn.jd.login.stage.LoginStage;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@EnableAsync
public class App extends AbstractJavaFxApplicationSupport {

	static Logger logger = LoggerFactory.getLogger(App.class);


    public static void main(String[] args) {
	    launch(App.class,LoginController.class,new Splash(),args);//springboot-javafx-support启动方式
	    logger.info("initial success!");
	    //App.showView(RegisterController.class);
    }

	/**
	 * 初始化构建主界面
	 */
	@Override
	public void start(Stage primaryStage) throws Exception{
		LoginStage loginStage = new LoginStage();
		LoginController.loginStage = loginStage;
	}


	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
	}


}
