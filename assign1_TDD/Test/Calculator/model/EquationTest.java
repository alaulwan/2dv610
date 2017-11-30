package Calculator.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class EquationTest {
	private Equation sut;

	@Test
	public void EquationClass_CreateNewEquation_ReturnCorrectFactors() {
		sut = new Equation(1.3, 2.05, -3);
		{
			double actual = sut.getA();
			double expected = 1.3;
			assertTrue(printTip(expected, actual), doublecomparision(expected, actual));
		}

		{
			double actual = sut.getB();
			double expected = 2.05;
			assertTrue(printTip(expected, actual), doublecomparision(expected, actual));
		}

		{
			double actual = sut.getC();
			double expected = -3;
			assertTrue(printTip(expected, actual), doublecomparision(expected, actual));
		}

	}

	private boolean doublecomparision(double expected, double actual) {
		double c = expected - actual;
		if (c < 0)
			c = -c;
		return c < 0.000000000000000000001;
	}

	private String printTip(double expected, double actual) {
		return "Expected: " + expected + " , Actual: " + actual;
	}

}
