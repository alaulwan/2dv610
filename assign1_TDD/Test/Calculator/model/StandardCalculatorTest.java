package Calculator.model;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class StandardCalculatorTest {
	private StandardCalculator sut;
	private double[] doubleArray1 = new double[100], doubleArray2 = new double[100], actualArray = new double[100],
			expectedArray = new double[100];

	@Before
	public void setUp() throws Exception {
		Random r = new Random(0 - 1000000);
		for (int i = 0; i < 100; i++) {
			doubleArray1[i] = r.nextDouble();
			doubleArray2[i] = r.nextDouble();
		}
		sut = new StandardCalculator();
	}

	@Test
	public void sumTestReturnSumOfTwoNumber() {
		for (int i = 0; i < 100; i++) {
			actualArray[i] = sut.sum(doubleArray1[i], doubleArray2[i]);
			expectedArray[i] = doubleArray1[i] + doubleArray2[i];
			assertTrue(printTip(expectedArray[i], actualArray[i]), doublecomparision(expectedArray[i], actualArray[i]));
		}
	}

	@Test
	public void subtractTestReturnSubtractOfTwoNumber() {
		for (int i = 0; i < 100; i++) {
			actualArray[i] = sut.subtract(doubleArray1[i], doubleArray2[i]);
			expectedArray[i] = doubleArray1[i] - doubleArray2[i];
			assertTrue(printTip(expectedArray[i], actualArray[i]), doublecomparision(expectedArray[i], actualArray[i]));
		}
	}

	private boolean doublecomparision(double expected, double actual) {
		double c = expected - actual;
		if (c < 0)
			c = -c;
		// print (expected, actual);
		return c < 0.000000000000000000001;
	}

	private String printTip(double expected, double actual) {
		return "Expected: " + expected + " , Actual: " + actual;
	}

}
