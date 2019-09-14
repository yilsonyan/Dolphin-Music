package cn.jd.login.stage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class RegisterStage extends Stage{

	{
		URL url = getClass().getClassLoader().getResource("fxml/register.fxml");
		Parent root = null;
		try {
			root = FXMLLoader.load(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root, 400, 500);
		this.setTitle("注册新用户");
		//loginStage.setFullScreen(true);
		this.setScene(scene);
		this.getIcons().add(new Image("static/icon.png"));
		this.show();
	}


}
