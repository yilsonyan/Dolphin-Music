package cn.jd.login.controller;

import cn.jd.util.VerifyCodeUtil;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
	@FXML
	private TextField inputCodeTextField;

	//验证码
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
	public void backBtn(ActionEvent event) throws IOException {
		registerStage.close();
		primaryStage.show();
	}


	@FXML
	public void registerBtn(ActionEvent event) throws IOException {
		msg.setFill(Color.FIREBRICK);
		msg.setText("请稍候");
	}


	//监听键盘回车事件：登录
	@FXML
	public void enterEvent(KeyEvent event) throws IOException {
		if(event.getCode() == KeyCode.ENTER){
			// do something
			registerBtn(null);
		}
	}


}
