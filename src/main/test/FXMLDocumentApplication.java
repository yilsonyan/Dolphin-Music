import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;

/**
 *
 * @author Administrator
 */
public class FXMLDocumentApplication extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		URL url = getClass().getClassLoader().getResource("FXMLDocument.fxml");
		//Parent root = FXMLLoader.load(url);
		Parent root = FXMLLoader.load(url);

		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.show();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}