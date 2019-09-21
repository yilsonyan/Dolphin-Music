package cn.yan.login.controller;

import cn.yan.login.stage.MainStage;
import cn.yan.login.stage.RegisterStage;
import cn.yan.util.DialogBuilder;
import cn.yan.validator.LoginValidator;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLController;
import de.felixroske.jfxsupport.FXMLView;
import de.felixroske.jfxsupport.GUIState;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.javafx.FontIcon;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

@FXMLController
@FXMLView(value = "/fxml/login.fxml")
public class LoginController extends AbstractFxmlView implements Initializable {

	//根节点
	@FXML
	private GridPane root;

    @FXML
    private JFXTextField usernameField;

	@FXML
	private JFXPasswordField passwordField;

    //记住按钮
    @FXML
    private JFXToggleButton rememberMe;

    //登录按钮
    @FXML
    private JFXButton signIn;

	//注册按钮
	@FXML
	private JFXButton register;

	//登录提示信息
	@FXML
	private Text msg;

    //登录界面
	public static Stage loginStage ;
	//注册界面
	public static Stage registerStage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//取到Stage
		//Stage stage = App.getStage();
		loginStage = GUIState.getStage();
		loginStage.setTitle("Dolphin Music");
		//去除窗口标题栏
		//stage.initStyle(StageStyle.TRANSPARENT);
		//设置不可调整大小
		//stage.setResizable(false);
		loginStage.setResizable(true);
		//设置窗口最小化
		//stage.setIconified(true);
		//设置窗口关闭按钮事件
		loginStage.setOnCloseRequest(
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

		//登录按钮事件
		signIn.setOnMouseClicked(event -> signInBtn(event));

		//注册按钮事件
		register.setOnMouseClicked(event -> registerBtn(event));

		//监听键盘回车事件：登录
		root.setOnKeyPressed(event -> enterKeyEvent(event));

	}

	//登录按钮事件
	private void signInBtn(MouseEvent event) {
		//校验
		boolean usernameValidate = usernameField.validate();
		boolean passwordValidate = passwordField.validate();
		if (usernameValidate && passwordValidate){
			//登录验证
			String userName = usernameField.getCharacters().toString();
			String password = passwordField.getCharacters().toString();
			if ("admin".equals(userName) && "admin".equals(password)) {
				//弹框提示
				new DialogBuilder(usernameField).
						setTitle("Message").
						setMessage("Login success! Waiting to initial...").
						create();

				//判断是否勾选记住帐号和密码
				boolean selected = rememberMe.isSelected();
				if (selected){
					saveLoginInfo(userName,password);
				}

				loginStage.close();
				new MainStage();
			} else {
				msg.setFill(Color.FIREBRICK);
				msg.setText("Authentication failed!");
			}
		}
	}

	//注册按钮事件
	private void registerBtn(MouseEvent event) {
		loginStage.hide();
		registerStage = new RegisterStage();

		//对下一个页面赋值
		RegisterController.primaryStage = loginStage;
		RegisterController.registerStage = registerStage;
	}


	//监听键盘回车事件：登录
	public void enterKeyEvent(KeyEvent event) {
		if(event.getCode() == KeyCode.ENTER){
			signInBtn(null);
		}
	}


	//序列化登录信息
	private void saveLoginInfo(String userName,String password) {
		new Thread(()->{
			HashMap<String, String> map = new HashMap<>();
			map.put("userName",userName);
			map.put("password",password);
			//序列化
			URL url = this.getClass().getClassLoader().getResource("config");
			File serializableFile = new File(url.getPath()+"/Serializable");
			try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(serializableFile))){
				if (!serializableFile.exists()){
					serializableFile.createNewFile();
				}
				objectOutputStream.writeObject(map);
				objectOutputStream.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();

	}


}
