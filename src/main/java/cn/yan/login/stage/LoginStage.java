package cn.yan.login.stage;

import cn.yan.login.config.LonginStageConfig;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;


public class LoginStage extends Stage {

	{
		URL url = getClass().getClassLoader().getResource("fxml/login.fxml");
		AnchorPane root = null;
		try {
			root = FXMLLoader.load(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//添加css

		Scene scene = new Scene(root, LonginStageConfig.width, LonginStageConfig.height);
		//scene.getStylesheets().add(this.getClass().getClassLoader().getResource("css/Login.css").toExternalForm());
		scene.getStylesheets().add("css/Login.css");



		this.setScene(scene);
		this.setTitle("Dolphin Music");
		//this.setFullScreen(true);
		this.setResizable(false);//设置不可调整大小
		//设置窗口的图标
		this.getIcons().add(new Image("/static/icon.png"));
		this.show();


		//关闭事件
		this.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {

				//对话框 Alert Alert.AlertType.CONFIRMATION：反问对话框
				/*
			    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			    //设置对话框标题
			    alert.setTitle("Exit");
			    //设置内容
			    alert.setHeaderText("Are you sure to exit");
			    //显示对话框
			    Optional<ButtonType> result = alert.showAndWait();
			    //如果点击OK
			    if (result.get() == ButtonType.OK){
				    // ... user chose OK
				    System.exit(0);
				    //否则
			    } else {
				    event.consume();
			    }
				*/
			}
		});
	}



}
