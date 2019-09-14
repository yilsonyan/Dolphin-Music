package cn.jd.login.stage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;


public class MainStage extends Stage {

	//初始化界面
	{
		URL url = getClass().getClassLoader().getResource("fxml/main.fxml");
		AnchorPane root = null;
		try {
			root = FXMLLoader.load(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root, 400, 500);
		Stage mainStage = new Stage();
		mainStage.setTitle("单向走丝线切割数据库");
		//primaryStage.setFullScreen(true);
		mainStage.setScene(scene);
		//设置窗口的图标.
		mainStage.getIcons().add(new Image("static/icon.png"));
		mainStage.show();
	}




}
