package Calculator.model;

public class AdvancedCalculator {

	public double squareRoot (double A)  {
		if (A>=0) {
			return Math.sqrt(A);
		}
		throw new IllegalArgumentException("Can not Square Root a negative number");
	}

}
