package Calculator.model;


public class StandardCalculator {

	public double sum(double number1, double number2) {
		return number1 + number2;
	}

	public double subtract(double number1, double number2) {
		return number1 - number2;
	}

	public double mul(double number1, double number2) {
		return number1 * number2;
	}
	
	public double divide (double A, double B) {
		if (B!=0) {
			return A/B;
		}
		return Double.MIN_VALUE;
	}

}
