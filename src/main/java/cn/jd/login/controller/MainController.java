package cn.jd.login.controller;

import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLView;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

//@FXMLController
@FXMLView(value = "/fxml/main.fxml")
public class MainController extends AbstractFxmlView implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Parent view = getView();
	}
}