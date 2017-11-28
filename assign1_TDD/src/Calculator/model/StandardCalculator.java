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

	public double divide(double number1, double number2) {
		if (number2 != 0) {
			return number1 / number2;
		}
		throw new IllegalArgumentException("Number2 'divisor' is 0");
	}

	public double mod(double number1, double number2) {
		if (number2 != 0) {
			return number1 % number2;
		}
		throw new IllegalArgumentException("Number2 'divisor' is 0");
	}
}
