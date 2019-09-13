import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLDocumentController implements Initializable {

	@FXML
	private ProgressBar process1;
	@FXML
	private ProgressIndicator process2;
	@FXML
	private Text process3;
	@FXML
	private Button bt1;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//按钮注册事件处理函数
		bt1.setOnAction(e->handleButtonAction(e));
	}

	//按钮事件处理函数
	private void handleButtonAction(ActionEvent event) {

		Service<String> service=new Service<String>() {
			@Override
			protected Task<String> createTask() {
				return new Task<String>() {
					@Override
					protected String call() throws Exception {
						for(int a=1;a<=100;a++){
							//更新service的value属性
							updateValue("process:"+a+"%");
							//更新service的progress属性
							updateProgress(a, 100d);
							Thread.sleep(100);
						}
						return "success";
					}
				};
			}
		};

		//绑定process1的progress属性为service的progress属性
		process1.progressProperty().bind(service.progressProperty());
		//同上
		process2.progressProperty().bind(service.progressProperty());
		//绑定process3的text属性为service的text属性
		process3.textProperty().bind(service.valueProperty());
		//任务完成时会调用
		service.setOnSucceeded((WorkerStateEvent stateEvent) -> {
			System.out.println("任务处理完成！");
		});
		//启动任务start()一定是最后才调用的
		service.start();
	}



}