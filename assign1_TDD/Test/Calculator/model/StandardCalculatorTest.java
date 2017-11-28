package Calculator.model;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class StandardCalculatorTest {
	private StandardCalculator sut;
	private double[] doubleArray1 = new double[100];
	private double[] doubleArray2 = new double[100];

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
	public void sum_RandomTowNumber_ReturnSum() {
		for (int i = 0; i < 100; i++) {
			double actual = sut.sum(doubleArray1[i], doubleArray2[i]);
			double expected = doubleArray1[i] + doubleArray2[i];
			assertTrue(printTip(expected, actual), doublecomparision(expected, actual));
		}
	}

	@Test
	public void subtract_RandomTowNumber_ReturnSubtract() {
		for (int i = 0; i < 100; i++) {
			double actual = sut.subtract(doubleArray1[i], doubleArray2[i]);
			double expected = doubleArray1[i] - doubleArray2[i];
			assertTrue(printTip(expected, actual), doublecomparision(expected, actual));
		}
	}

	@Test
	public void mul_RandomTowNumber_ReturnMultiplication() {
		for (int i = 0; i < 100; i++) {
			double actual = sut.mul(doubleArray1[i], doubleArray2[i]);
			double expected = doubleArray1[i] * doubleArray2[i];
			assertTrue(printTip(expected, actual), doublecomparision(expected, actual));
		}
	}

	@Test
	public void divide_RandomTowNumber_ReturnDivide() {
		for (int i = 0; i < 100; i++) {
			double actual = sut.divide(doubleArray1[i], doubleArray2[i]);
			double expected = doubleArray1[i] / doubleArray2[i];
			assertTrue(printTip(expected, actual), doublecomparision(expected, actual));
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void divide_ZeroDivisor_ThrowExeption() {
		sut.divide(5, 0);
	}

	@Test
	public void mod_RandomTowNumber_ReturnModule() {
		for (int i = 0; i < 100; i++) {
			double actual = sut.mod(doubleArray1[i], doubleArray2[i]);
			double expected = doubleArray1[i] % doubleArray2[i];
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
