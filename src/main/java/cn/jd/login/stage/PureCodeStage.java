package cn.jd.login.stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static javafx.geometry.HPos.RIGHT;

public class PureCodeStage {

		/**
		 * 纯代码方式构建主界面
		 */
		//@Override
		public void start1(Stage primaryStage) {
		/**
		 * 舞台,是应用程序窗口
		 */
		primaryStage.setFullScreen(true);
		primaryStage.setTitle("单向走丝线切割数据库");

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("Welcome");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label userNameStr = new Label("User Name:");
		grid.add(userNameStr, 0, 1);

		TextField userNameText = new TextField();
		grid.add(userNameText, 1, 1);

		Label passwordStr = new Label("Password:");
		grid.add(passwordStr, 0, 2);

		PasswordField passwordBox = new PasswordField();
		grid.add(passwordBox, 1, 2);

		/**
		 * 登录按钮
		 */
		Button btn = new Button("Sign in");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 4);

		final Text actiontarget = new Text();
		grid.add(actiontarget, 0, 6);
		grid.setColumnSpan(actiontarget, 2);
		grid.setHalignment(actiontarget, RIGHT);
		actiontarget.setId("actiontarget");

		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				actiontarget.setFill(Color.FIREBRICK);

				//登录验证
				CharSequence userName = userNameText.getCharacters();
				CharSequence password = passwordBox.getCharacters();

				if (userName.length() == 0){
					actiontarget.setText("用户名不能为空!");
				}
				if (password.length() == 0){
					actiontarget.setText("密码不能为空!");
				}
				if ("111".equals(userName) && "111".equals(password)){
					System.exit(0);
				}else {
					actiontarget.setText("登录验证失败!");
				}

				//actiontarget.setText("Sign in button pressed");
			}
		});

		//Scene包含界面的组件
		Scene scene = new Scene(grid, 300, 275);

		//舞台大小
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
