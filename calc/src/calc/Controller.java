package calc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
/**
 * Klasa kontrolera
 * Odpowiada za obs�ug� zdarze� i ��czenie cz�ci logicznej (Model) z Widokiem
 * 
 * display - po��czenie z polem tekstu
 * init - pokazuje czy nale�y rozpocz�� nowe dzia�anie
 * isDecimal - czy obecny string jest u�amkiem
 * value1 - przechowuje pierwsz� liczb� w dzia�aniu po wybraniu operatora
 * operator - aby wiedzie� jakie dzia�anie nale�y wykona�
 * @author BP
 *
 */
public class Controller {
	
	@FXML
	private Text display;
	
	private boolean init = true;
	private boolean isDecimal = false;
	private double value1 = 0;
	private String operator = "";
	
	
	private Model model = new Model();
	/**
	 * Reset wy�wietlacza
	 */
	private void cleardisplay() {
		display.setText("");
	}
	/**
	 * Obs�uga naci�ni�cia klawiszy numerycznych
	 * @param event
	 */
	@FXML
	private void actionDigit(ActionEvent event) {
		if(init) {
			cleardisplay();
			init = false;
		}
		
		String value = ((Button)event.getSource()).getText();
		display.setText(display.getText() + value);
	}
	/**
	 * Odpowiada za wprowadzanie u�amk�w do widoku
	 * @param event
	 */
	@FXML
	private void actionDecimal(ActionEvent event) {
		if(!isDecimal) {
			String value = ((Button)event.getSource()).getText();
			display.setText(display.getText() + value);
			isDecimal = true;
		}
		
	}
	/**
	 * Okre�lenie rodzaju dzia�ania. Nie obs�uguje operatora SQRT. 
	 * Metoda ta zapisuje pierwsz� liczb� do zmiennej value1 oraz operator do zmiennej operator
	 * @param event
	 */
	@FXML
	private void actionOperator(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();

            if (!operator.isEmpty())
                return;

            operator = value;
            value1 = Double.parseDouble(display.getText());
            cleardisplay();
            isDecimal = false;
        
	}
	
	/**
	 * Wykonanie dzia�ania.
	 * Dzielenie przez zero uruchamia odpowiedni alert
	 * @param event
	 */
    @FXML
    private void actionCalculate(ActionEvent event) {
    	 if (operator.isEmpty())
             return;
         
         if(Double.parseDouble(display.getText()) == 0 && operator.equals("/")) {
         	
         	Popup popup = new Popup();
 			popup.displayErrorMsg("Cannot divide by zero!");
 			cleardisplay();
 			operator = "";
 			init = true;
 			isDecimal = false;
 			return;
         } 
                   
         String val = String.valueOf(model.calculate(value1, Double.parseDouble(display.getText()), operator));
         
         if(val.charAt(val.length() - 2) == '.' && val.charAt(val.length() - 1) == '0') {
         	val = val.substring(0, val.length()-2);
         }
         
         display.setText(val);
         operator = "";
         init = true;
    }
    
	
	/**
	 * Pierwiastkowanie kwadratowe przyjmuje tylko jeden argument, wi�c jest obs�ugiwane oddzielnie.
	 * @param event
	 */
	@FXML
	private void actionOperatorSQRT(ActionEvent event) {
		value1 = Double.parseDouble(display.getText());
		if(value1 >= 0)
			 display.setText(String.valueOf(model.calculateSquareRoot(value1)));
		else {
			Popup popup = new Popup();
			popup.displayErrorMsg("Cannot find the square root of a negative number");
		}
        operator = "";
        init = true;
	}
	/**
	 * Przywraca kalkulator do stanu bazowego
	 * @param event
	 */
	@FXML
	private void actionClear(ActionEvent event) {
		value1 = 0;
		operator = "";
		cleardisplay();
		isDecimal = false;
		init = true;
	}
	/**
	 * Zmienia wy�wietlan� liczb� na ujemn� lub dodatni�
	 * @param event
	 */
	@FXML
	private void actionNegate(ActionEvent event) {
		String val = display.getText();
		if(val.charAt(0) == '-') {
			val = val.substring(1);
			display.setText(val);
		}
		else
			display.setText("-".concat(display.getText()));
		
	}
}
