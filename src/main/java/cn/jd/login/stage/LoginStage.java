package cn.jd.login.stage;

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
		//Parent root = FXMLLoader.load(url);
		AnchorPane root = null;
		try {
			root = FXMLLoader.load(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root, 400, 500);

		this.setTitle("单向走丝线切割数据库");
		//primaryStage.setFullScreen(true);
		this.setScene(scene);
		//设置窗口的图标.
		this.getIcons().add(new Image("static/icon.png"));
		this.show();

		//关闭事件
		this.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {

				//对话框 Alert Alert.AlertType.CONFIRMATION：反问对话框
			    /*Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			    //设置对话框标题
			    alert.setTitle("Exit");
			    //设置内容
			    alert.setHeaderText("Are you sure to exit");
			    //显示对话框
			    Optional<ButtonType> result = alert.showAndWait();
			    //如果点击OK
			    if (result.get() == ButtonType.OK){
				    // ... user chose OK
				    loginStage.close();
				    //否则
			    } else {
				    event.consume();
			    }*/
			}
		});
	}



}
