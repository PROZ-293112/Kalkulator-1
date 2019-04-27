package calc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Kalkulator, Projekt PROZ nr 1 
 * 
 * @author Bart³omiej Partyka
 *@version 1.0
 */
public class Main extends Application{

	/**
	 * £adowanie widoku z pliku fxml
	 * View.fxml zbudowany w Scene Builder
	 */
	@Override
	public void start(Stage arg0) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
		arg0.setTitle("Kalkulator");
		arg0.setScene(new Scene(root));
		arg0.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}


}
