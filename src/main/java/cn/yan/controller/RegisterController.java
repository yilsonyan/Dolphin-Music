package cn.yan.controller;

import cn.yan.App;
import cn.yan.util.DialogBuilder;
import cn.yan.util.VerifyCodeUtil;
import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLController;
import de.felixroske.jfxsupport.FXMLView;
import de.felixroske.jfxsupport.GUIState;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
@FXMLView(value = "/fxml/register.fxml",title = "index")
public class RegisterController extends AbstractFxmlView implements Initializable {

	//主面板
    @FXML
    private GridPane anchorPane;

	//注册按钮
	@FXML
	private Button registerBtn;

	//返回按钮
	@FXML
	private Button backBtn;

    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;

	//验证码
	@FXML
	private TextField inputCodeTextField;

	//验证码图片
	@FXML
	public ImageView codeImage;

    //注册提示信息
    @FXML
    private Text msg;


	/**
	 * 初始化时调用的方法
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Stage stage = GUIState.getStage();
		Scene scene = GUIState.getScene();
		scene.getStylesheets().add("css/register.css");
		stage.setScene(scene);
		/*stage.setTitle("Dolphin Music");
		//this.setFullScreen(true);
		stage.setResizable(false);//设置不可调整大小
		//设置窗口的图标
		stage.getIcons().add(new Image("/static/icon.png"));*/

		generateImageCode();
		//主面板回车事件
		anchorPane.setOnKeyPressed(e->enterEvent(e));
		registerBtn.setOnAction(e->registerBtn(e));
		backBtn.setOnAction(e->backBtn(e));
		codeImage.setOnMouseClicked(e->generateImageCode());
		//验证码生成后再设置注册按钮可以点击，否则后台验证时，后台的验证码还没有生成。
		registerBtn.setDisable(true);

	}



	/**
	 * 生成验证码
	 */
	@FXML
	public void generateImageCode() {
		Service<Image> service=new Service<Image>() {
			@Override
			protected Task<Image> createTask() {
				return new Task<Image>() {
					@Override
					protected Image call() throws Exception {
						//生成验证码图片，并返回fx包下的ImageView对象
						Image image = VerifyCodeUtil.generateImageCode();
						return image;
					}
				};
			}
		};

		//绑定text属性为service的text属性
		codeImage.imageProperty().bind(service.valueProperty());

		//任务完成时会调用
		service.setOnSucceeded((WorkerStateEvent stateEvent) ->
			//验证码生成后再设置注册按钮可以点击，否则后台验证时，后台的验证码还没有生成。
			registerBtn.setDisable(false)
		);
		//启动任务start()一定是最后才调用的
		service.start();
	}



	@FXML
	public void backBtn(ActionEvent event) {
		/*registerStage.close();
		primaryStage.show();*/

		App.showView(LoginController.class);
	}


	@FXML
	public void registerBtn(ActionEvent event){
		msg.setFill(Color.FIREBRICK);

		//验证码校验
		String text = VerifyCodeUtil.getText();
		//与用户输入的做对比
		String inputCode = inputCodeTextField.getCharacters().toString();
		if (!text.equalsIgnoreCase(inputCode)){
			msg.setText("Wrong Verify Code!");
			return;
		}

		//用户名重复校验
		if (1==1){
			//注册成功提示弹窗
			new DialogBuilder(null).
				setTitle("Congratulations!").
				setMessage("Register success!").
				setPositiveBtn("Get It", () -> {}).
				createAndWait();
			//跳转回登陆页面
			backBtn(null);
		}else {
			//注册失败提示弹窗
			new DialogBuilder(null).
				setTitle("Oops!").
				setMessage("Register failed!").
				setPositiveBtn("Get It", () -> {}).
				createAndWait();
		}

	}


	//监听键盘回车事件：登录
	@FXML
	public void enterEvent(KeyEvent event){
		if(event.getCode() == KeyCode.ENTER){
			// do something
			registerBtn(null);
		}
	}


}
