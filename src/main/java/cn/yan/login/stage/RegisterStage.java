package cn.yan.login.stage;

import cn.yan.login.config.SceneConfig;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class RegisterStage extends Stage{

	{
		URL url = getClass().getClassLoader().getResource("fxml/register.fxml");
		AnchorPane root = null;
		try {
			root = FXMLLoader.load(url);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//添加css
		Scene scene = new Scene(root, SceneConfig.width, SceneConfig.height);
		//scene.getStylesheets().add(this.getClass().getClassLoader().getResource("css/Login.css").toExternalForm());
		scene.getStylesheets().add("css/register.css");


		this.setScene(scene);
		this.setTitle("Dolphin Music");
		//this.setFullScreen(true);
		this.setResizable(false);//设置不可调整大小
		//设置窗口的图标
		this.getIcons().add(new Image("/static/icon.png"));
		this.show();
	}





}
