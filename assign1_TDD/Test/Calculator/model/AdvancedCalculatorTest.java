package Calculator.model;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AdvancedCalculatorTest {
	
	private AdvancedCalculator sut;
	private double[] doubleArray1 = new double[100];
	private double[] doubleArray2 = new double[100];

	@Before
	public void setUp() throws Exception {
		Random r = new Random(0 - 1000000);
		for (int i = 0; i < 100; i++) {
			doubleArray1[i] = r.nextDouble();
			doubleArray2[i] = r.nextDouble();
		}
		sut = new AdvancedCalculator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void squareRoot_RandomPositiveNumbers_ReturnTheRoot() {
		for (int i = 0; i < 100; i++) {
			double actual = sut.squareRoot(doubleArray1[i]);
			double expected = Math.sqrt(doubleArray1[i]);
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
