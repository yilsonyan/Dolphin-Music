package cn.yan;

import cn.yan.login.config.Splash;
import cn.yan.login.controller.LoginController;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import de.felixroske.jfxsupport.GUIState;
import de.felixroske.jfxsupport.PropertyReaderHelper;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;


@SpringBootApplication
//@EnableTransactionManagement
//@EnableScheduling
//@EnableAsync
public class App extends AbstractJavaFxApplicationSupport {

	static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
		//launch(App.class, LoginController.class, args);//springboot-javafx-support启动方式
		launch(App.class, LoginController.class, new Splash(), args);//springboot-javafx-support启动方式
	    logger.info("启动成功");
    }

    //重写默认icon
    @Override
	public Collection<Image> loadDefaultIcons() {
		return Arrays.asList(new Image("static/icon.png"));
	}


	//静态方法不可继承，但可以访问
	/*@Override
	public static void setTitle(String title) {
		GUIState.getStage().setTitle(title);
	}*/



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
