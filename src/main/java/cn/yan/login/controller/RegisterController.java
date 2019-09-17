package cn.yan.login.controller;

import cn.yan.util.VerifyCodeUtil;
import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLController;
import de.felixroske.jfxsupport.FXMLView;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
@FXMLView(value = "fxml/register.fxml",title = "index")
public class RegisterController extends AbstractFxmlView implements Initializable {

	//主面板
    @FXML
    private AnchorPane anchorPane;

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

    //登录界面
	public static Stage primaryStage;
	//注册界面
	public static Stage registerStage;


	/**
	 * 初始化时调用的方法
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		generateImageCode();
		//主面板回车事件
		anchorPane.setOnKeyPressed(e->enterEvent(e));
		registerBtn.setOnAction(e->registerBtn(e));
		backBtn.setOnAction(e->backBtn(e));
		codeImage.setOnMouseClicked(e->generateImageCode());


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
		service.setOnSucceeded((WorkerStateEvent stateEvent) -> {
			//System.out.println("任务处理完成！");
		});
		//启动任务start()一定是最后才调用的
		service.start();
	}



	@FXML
	public void backBtn(ActionEvent event) {
		registerStage.close();
		primaryStage.show();
	}


	@FXML
	public void registerBtn(ActionEvent event){
		msg.setFill(Color.FIREBRICK);

		//验证码校验
		String text = VerifyCodeUtil.getText();
		//与用户输入的做对比
		String inputCode = inputCodeTextField.getCharacters().toString();
		if (!text.equalsIgnoreCase(inputCode)){
			msg.setText("验证码输入错误");
			return;
		}
		//用户名重复校验

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("信息");
		alert.setHeaderText("注册成功");

		//注册成功
		//用户点击确定后，关闭注册窗口，进入登录窗口
		alert.setOnCloseRequest(new EventHandler<DialogEvent>() {
			@Override
			public void handle(DialogEvent event) {
				registerStage.close();
				primaryStage.show();
			}
		});
		alert.show();
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
