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
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
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
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
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
	public static Stage loginStage;
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
		loginStage.setResizable(false);
		//loginStage.setResizable(true);
		//设置窗口最小化
		//stage.setIconified(true);
		//设置窗口关闭按钮事件
		loginStage.setOnCloseRequest(
			event -> new DialogBuilder(usernameField).
			setTitle("Oops!").
			setMessage("Do you really want to leave me alone?").
			setPositiveBtn("Sorry for that", () -> {}).
			setNegativeBtn("Cancel", () -> event.consume()).
			create()
		);

	}


	@PostConstruct
	public void init() throws Exception {

		//加载样式css
		Parent view = getView();
		view.getStylesheets().add("css/login.css");
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

		//输入框绑定序列化登录信息
		getLoginInfo();

	}

	//登录按钮事件
	private void signInBtn(MouseEvent event) {
		//校验
		boolean usernameValidate = usernameField.validate();
		boolean passwordValidate = passwordField.validate();
		if (usernameValidate && passwordValidate) {
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
				if (selected) {
					saveLoginInfo(userName, password);
				} else {
					//删除序列化文件
					deleteLoginInfo();
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
		if (event.getCode() == KeyCode.ENTER) {
			signInBtn(null);
		}
	}


	//序列化登录信息
	private void saveLoginInfo(String userName, String password) {
		new Thread(() -> {
			HashMap<String, String> map = new HashMap<>();
			map.put("userName", userName);
			map.put("password", password);
			//序列化
			URL url = this.getClass().getClassLoader().getResource("");
			File serializableFile = new File(url.getPath() + "/user.serializable");
			try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(serializableFile))) {
				if (!serializableFile.exists()) {
					serializableFile.createNewFile();
				}
				objectOutputStream.writeObject(map);
				objectOutputStream.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();

	}



	//删除序列化文件
	public void deleteLoginInfo() {
		new Thread(() -> {
			//获取序列化文件
			URL url = this.getClass().getClassLoader().getResource("");
			File serializableFile = new File(url.getPath() + "/user.serializable");
			try {
				if (serializableFile.exists()) {
					serializableFile.delete();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
	}



	//输入框绑定序列化登录信息
	private void getLoginInfo() throws Exception{
		Map<String, String> loginInfo;
		//获取序列化文件
		URL url = this.getClass().getClassLoader().getResource("");
		File serializableFile = new File(url.getPath() + "/user.serializable");
		if (!serializableFile.exists()) {
			return;
		}else {
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(serializableFile));
			loginInfo = (Map<String, String>) objectInputStream.readObject();
			objectInputStream.close();
		}

		Service<String> readUserNameService = new Service<String>() {
			@Override
			protected Task<String> createTask() {
				return new Task<String>() {
					@Override
					protected String call() {
						String userName = "";
						//Map<String, String> loginInfo = readLoginInfo();
						if (loginInfo != null){
							userName = loginInfo.get("userName");
						}
						return userName;
					}
				};
			}
		};

		Service<String> readPwdService = new Service<String>() {
			@Override
			protected Task<String> createTask() {
				return new Task<String>() {
					@Override
					protected String call() {
						String password = "";
						//Map<String, String> loginInfo = readLoginInfo();
						if (loginInfo != null){
							password = loginInfo.get("password");
						}
						return password;
					}
				};
			}
		};

		//绑定text属性为service的text属性
		usernameField.textProperty().bind(readUserNameService.valueProperty());
		passwordField.textProperty().bind(readPwdService.valueProperty());

		//任务完成时会调用：界面绑定写入信息后，解绑，否则界面上不能修改输入的内容
		readUserNameService.setOnSucceeded((WorkerStateEvent stateEvent) -> {
			usernameField.textProperty().unbind();
		});
		//任务完成时会调用
		readPwdService.setOnSucceeded((WorkerStateEvent stateEvent) -> {
			passwordField.textProperty().unbind();
		});

		//设置记住按钮为勾选状态
		rememberMe.setSelected(true);

		//启动任务start()一定是最后才调用的
		readUserNameService.start();
		readPwdService.start();
	}


}
