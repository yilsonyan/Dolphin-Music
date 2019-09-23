package cn.yan.login.stage;

import cn.yan.util.DialogBuilder;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;


public class MainStage extends Stage {

	//初始化界面
	{
		try {
			URL url = getClass().getClassLoader().getResource("fxml/main.fxml");
			AnchorPane root = FXMLLoader.load(url);
			Scene scene = new Scene(root, 500, 600);
			Stage mainStage = new Stage();
			mainStage.setTitle("Dolphin Music");
			//primaryStage.setFullScreen(true);
			mainStage.setScene(scene);
			//设置窗口的图标.
			mainStage.getIcons().add(new Image("static/icon.png"));

			mainStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent event) {
					new DialogBuilder(null)
						.setTitle("提示")
						.setMessage("登录成功")
						.setPositiveBtn("确定", ()->{})
						.setNegativeBtn("取消", new DialogBuilder.OnClickListener() {
							@Override
							public void onClick() {
								event.consume();
							}
						})
						.create();
				}
			});

			mainStage.show();

		}catch (IOException e) {
			e.printStackTrace();
		}
	}




}
