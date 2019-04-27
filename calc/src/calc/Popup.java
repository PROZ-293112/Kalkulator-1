package calc;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/**
 * Klasa pomocnicza s³u¿¹ca do szybkiego wyœwietlania okien typu alert
 * @author BP
 *
 */
public class Popup {
/**
 * Metoda otwieraj¹ca okno typu error
 * @param msg Kominukat b³êdu
 */
	public void displayErrorMsg(String msg) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setContentText(msg);
		alert.setHeaderText(null);
		alert.showAndWait();
	}
}
