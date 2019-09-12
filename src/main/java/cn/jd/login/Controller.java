package cn.jd.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button signInBtn;
    @FXML
    private Text msg;

    @FXML
    public void loginInBtn(ActionEvent event) {
        //登录验证
        //CharSequence userName = usernameTextField.getCharacters();
        //CharSequence password = passwordTextField.getCharacters();

        /*if (userName.length() == 0){
            msg.setText("用户名不能为空!");
        }
        if (password.length() == 0){
            msg.setText("密码不能为空!");
        }
        if ("111".equals(userName) && "111".equals(password)){
            System.exit(0);
        }else {
            msg.setText("登录验证失败!");
        }*/

        msg.setFill(Color.FIREBRICK);
        msg.setText("登录验证失败!");
    }



    @FXML
    public void alert(ActionEvent event) {
        Alert _alert = new Alert(Alert.AlertType.INFORMATION);
        _alert.setTitle("信息");
        _alert.setHeaderText("11111111");
        _alert.setContentText("aaaaaaaa");
        _alert.show();
    }
}
