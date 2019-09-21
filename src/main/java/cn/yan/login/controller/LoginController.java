package cn.yan.login.controller;

import cn.yan.login.stage.LoginStage;
import cn.yan.login.stage.MainStage;
import cn.yan.login.stage.RegisterStage;
import cn.yan.util.DialogBuilder;
import cn.yan.validator.LoginValidator;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLController;
import de.felixroske.jfxsupport.FXMLView;
import de.felixroske.jfxsupport.GUIState;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.javafx.FontIcon;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
@FXMLView(value = "/fxml/login.fxml")
public class LoginController extends AbstractFxmlView implements Initializable {

	@FXML
	private GridPane root;

    @FXML
    private JFXTextField usernameField;

	@FXML
	private JFXPasswordField passwordField;


    //登录提示信息
    @FXML
    private Text msg;

    @FXML
    private JFXButton loginIn;

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
		//stage.setResizable(false);
		stage.setResizable(true);
		//设置窗口最小化
		//stage.setIconified(true);
		//设置窗口关闭按钮事件
		stage.setOnCloseRequest(
			event -> new DialogBuilder(usernameField).
				setTitle("Oops!").
				setMessage("Do you really want to leave me alone?").
				setPositiveBtn("Sorry for that", ()->{}).
				setNegativeBtn("Cancel", ()->event.consume()).
				create()
		);



	}


	@PostConstruct
	public void init(){
		//加载样式css
		Parent view = getView();


		view.getStylesheets().add("css/Login.css");
		//view.setStyle("-fx-background-image:url(static/entrance-backgroud/entrance_bg1.jpg);-fx-background-size:500px");
		//loginIn.getStyleClass().add("button-raised");


		//用户名输入框验证
		//usernameField.setPromptText("With Validation..");
		LoginValidator validator = new LoginValidator();
		validator.setMessage("Input Required");
		FontIcon warnIcon = new FontIcon(FontAwesomeSolid.HEART);//验证失败的图标类型
		validator.setIcon(warnIcon);
		usernameField.getValidators().add(validator);
		usernameField.focusedProperty().addListener((o, oldVal, newVal) -> {
			if (!newVal) {
				usernameField.validate();
			}
		});

		//密码输入框验证
		//passwordField.setPromptText("Password");
		validator = new LoginValidator();
		validator.setMessage("Can't be empty");
		warnIcon = new FontIcon(FontAwesomeSolid.EXCLAMATION_TRIANGLE);
		validator.setIcon(warnIcon);
		passwordField.getValidators().add(validator);
		passwordField.focusedProperty().addListener((o, oldVal, newVal) -> {
			if (!newVal) {
				passwordField.validate();
			}
		});



	}


	@FXML
    public void loginInBtn(ActionEvent event) throws IOException {
        //登录验证
        CharSequence userName = usernameField.getCharacters();
        CharSequence password = passwordField.getCharacters();
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
	        new DialogBuilder(usernameField).
					setTitle("Message").
					setMessage("Login success! Waiting to initial...").
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
