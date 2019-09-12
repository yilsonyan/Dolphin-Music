package cn.jd.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Button btn1;
    @FXML
    private Label lab1;

    @FXML
    public void onButtonClick(ActionEvent event) {
        lab1.setText("HelloWorld");
        Alert _alert = new Alert(Alert.AlertType.INFORMATION);
        _alert.setTitle("信息");
        _alert.setHeaderText("11111111");
        _alert.setContentText("aaaaaaaa");

        _alert.show();

    }
}
