package calc;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/**
 * Klasa pomocnicza s�u��ca do szybkiego wy�wietlania okien typu alert
 * @author BP
 *
 */
public class Popup {
/**
 * Metoda otwieraj�ca okno typu error
 * @param msg Kominukat b��du
 */
	public void displayErrorMsg(String msg) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setContentText(msg);
		alert.setHeaderText(null);
		alert.showAndWait();
	}
}
