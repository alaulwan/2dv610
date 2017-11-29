package Calculator.model;

public class AdvancedCalculator {

	public double squareRoot(double positiveNumber) {
		if (positiveNumber >= 0) {
			return Math.sqrt(positiveNumber);
		}
		throw new IllegalArgumentException("Can not Square Root a negative number");
	}

}
