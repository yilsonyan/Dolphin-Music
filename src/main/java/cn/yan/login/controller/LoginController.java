package cn.yan.login.controller;

import cn.yan.login.stage.LoginStage;
import cn.yan.login.stage.MainStage;
import cn.yan.login.stage.RegisterStage;
import cn.yan.util.DialogBuilder;
import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLController;
import de.felixroske.jfxsupport.FXMLView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
@FXMLView(value = "/fxml/login.fxml")
public class LoginController extends AbstractFxmlView implements Initializable {

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;

    //登录提示信息
    @FXML
    private Text msg;

    //登录界面
	public static LoginStage loginStage;
	//注册界面
	public static RegisterStage registerStage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}


	@PostConstruct
	public void init(){
		Parent parent = getView();

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
	        new DialogBuilder(usernameTextField).setTitle("提示").setMessage("登录成功").setPositiveBtn("确定").setNegativeBtn("取消").create();


	        loginStage.close();
	        MainStage mainStage = new MainStage();
	        //mainStage.getStage();


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
