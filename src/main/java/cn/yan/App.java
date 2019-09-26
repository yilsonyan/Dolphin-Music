package cn.yan;

import cn.yan.config.scene.SplashConfig;
import cn.yan.controller.LoginController;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.scene.image.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Collection;


@SpringBootApplication
//@EnableTransactionManagement
//@EnableScheduling
//@EnableAsync
public class App extends AbstractJavaFxApplicationSupport {

	static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
		//launch(App.class, LoginController.class, args);//springboot-javafx-support启动方式
		launch(App.class, LoginController.class, new SplashConfig(), args);//springboot-javafx-support启动方式
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


	/*@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
	}*/

}
