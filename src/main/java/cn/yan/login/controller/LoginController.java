package cn.yan.login.controller;

import cn.yan.App;
import cn.yan.login.config.LonginStageConfig;
import cn.yan.login.stage.LoginStage;
import cn.yan.login.stage.MainStage;
import cn.yan.login.stage.RegisterStage;
import cn.yan.util.DialogBuilder;
import de.felixroske.jfxsupport.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import lombok.experimental.var;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@FXMLController
@FXMLView(value = "/fxml/login.fxml")
public class LoginController extends AbstractFxmlView implements Initializable {

	@FXML
	private AnchorPane root;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;

    //登录提示信息
    @FXML
    private Text msg;

    //登录界面
	public static LoginStage loginStage ;
	//注册界面
	public static RegisterStage registerStage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//取到Stage
		//Stage stage = App.getStage();
		Stage stage = GUIState.getStage();
		stage.setTitle("Dolphin Music");
		//去除窗口标题栏
		//stage.initStyle(StageStyle.TRANSPARENT);
		//设置不可调整大小
		stage.setResizable(false);
		//设置窗口最小化
		//stage.setIconified(true);
		//设置窗口关闭按钮事件
		stage.setOnCloseRequest(
			event -> new DialogBuilder(usernameTextField).
				setTitle("Oops!").
				setMessage("Are you confirm leave me?").
				setPositiveBtn("Yep", ()->{}).
				setNegativeBtn("Cancel", ()->event.consume()).
				create()
		);

	}


	@PostConstruct
	public void init(){

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
	        //弹框提示
	        new DialogBuilder(usernameTextField).
					//setTitle("Message").
					setMessage("Login success!").
					create();

	        loginStage.close();
	        new MainStage();
        }else {
	        msg.setText("登录验证失败!");
        }
    }



	@FXML
	public void registerBtn(ActionEvent event) throws IOException {
		loginStage.hide();
		registerStage = new RegisterStage();
		//registerStage.getStage();

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
