package calc;
/**
 * Klasa modelu, obsługuje działania matematyczne
 * @author BP
 *
 */
public class Model {
/**
 * Funkcja wywoływana przez actionCalculate
 * @param value1 Pierwsza liczba w danej operacji
 * @param value2 Druga liczba w operacji
 * @param operator Typ operacji
 * @return Wynik
 */
    public double calculate(double value1, double value2, String operator) {
        switch (operator) {
            case "+":
                return value1 + value2;
            case "-":
                return value1 - value2;
            case "*":
                return value1 * value2;
            case "/":
                return value1 / value2;
            case "PWR":
            	return Math.pow(value1, value2);
        }
        return -1;
    }
    /**
     * Wywołynane przez actionOperatorSQRT
     * @param value1 Liczba pierwiastkowana
     * @return Wynik
     */
    public double calculateSquareRoot(double value1) {
    	return Math.sqrt(value1);
    }
}