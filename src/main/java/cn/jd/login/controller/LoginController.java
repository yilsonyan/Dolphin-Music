package cn.jd.login.controller;

import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@FXMLView//(value = "fxml/login.fxml")
public class LoginController extends AbstractFxmlView implements Initializable {

    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;

    //登录提示信息
    @FXML
    private Text msg;

    //登录界面
	public static Stage loginStage;
	//注册界面
	public static Stage registerStage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}



    @FXML
    public void loginInBtn(ActionEvent event) throws IOException {
        //登录验证
        CharSequence userName = usernameTextField.getCharacters();
        CharSequence password = passwordTextField.getCharacters();
	    msg.setFill(Color.FIREBRICK);
        if (userName.length() == 0){
            msg.setText("用户名不能为空!");
            return;
        }
        if (password.length() == 0){
            msg.setText("密码不能为空!");
	        return;
        }
        if ("admin".equals(userName.toString()) && "admin".equals(password.toString())){
	        /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setTitle("信息");
	        alert.setHeaderText("登录成功");
	        alert.setContentText("帐号密码验证通过");
	        alert.show();*/

	        loginStage.close();

	        URL url = getClass().getClassLoader().getResource("fxml/main.fxml");
	        AnchorPane root = FXMLLoader.load(url);
	        Scene scene = new Scene(root, 400, 500);
	        Stage mainStage = new Stage();
	        mainStage.setTitle("单向走丝线切割数据库");
	        //primaryStage.setFullScreen(true);
	        mainStage.setScene(scene);
	        //设置窗口的图标.
	        mainStage.getIcons().add(new Image("static/icon.png"));
	        mainStage.show();
        }else {
            msg.setText("登录验证失败!");
        }
    }



	@FXML
	public void registerBtn(ActionEvent event) throws IOException {
		loginStage.hide();

		registerStage = new Stage();
		URL url = getClass().getClassLoader().getResource("fxml/register.fxml");
		Parent root = FXMLLoader.load(url);
		Scene scene = new Scene(root, 400, 500);
		registerStage.setTitle("注册新用户");
		//loginStage.setFullScreen(true);
		registerStage.setScene(scene);
		registerStage.getIcons().add(new Image("static/icon.png"));
		registerStage.show();

		//对下一个页面赋值
		RegisterController.primaryStage = loginStage;
		RegisterController.registerStage = registerStage;
	}


	//监听键盘回车事件：登录
	@FXML
	public void enterEvent(KeyEvent event) throws IOException {
		if(event.getCode() == KeyCode.ENTER){
			// do something
			loginInBtn(null);
		}
	}



}
