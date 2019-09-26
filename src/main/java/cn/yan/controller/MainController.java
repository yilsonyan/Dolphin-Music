package cn.yan.controller;

import cn.yan.App;
import cn.yan.util.DialogBuilder;
import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLController;
import de.felixroske.jfxsupport.FXMLView;
import de.felixroske.jfxsupport.GUIState;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
@FXMLView(value = "/fxml/main.fxml")
public class MainController extends AbstractFxmlView implements Initializable {

	@FXML
	MenuItem about;

	@FXML
	MenuItem exit;



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//设置css样式
		Stage stage = GUIState.getStage();
		Scene scene = GUIState.getScene();
		scene.getStylesheets().add("css/login.css");
		stage.setScene(scene);



		//点击退出
		exit.setOnAction(e -> exitEvent(e));
		//点击关于
		about.setOnAction(e -> aboutEvent(e));


	}

	//点击退出
	public void exitEvent(ActionEvent event) {
		App.showView(LoginController.class);
	}


	//点击关于
	public void aboutEvent(ActionEvent event) {
		StringBuilder sb = new StringBuilder();
		sb.append("Author：yan" + "\n\r");
		sb.append("Date：2019-09-25" + "\n\r");
		sb.append("Version：1.0.0 Beta" + "\n\r");

		new DialogBuilder(null)
				.setTitle("About")
				.setMessage(sb.toString())
				.setPositiveBtn("Get it", () -> {})
				.create();
	}



}
