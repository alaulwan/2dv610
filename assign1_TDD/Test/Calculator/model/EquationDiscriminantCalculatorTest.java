package Calculator.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Calculator.model.exeption.NonQuadraticEquatioException;

public class EquationDiscriminantCalculatorTest {
	private EquationDiscriminantCalculator sut;
	private Equation mockEquation = mock(Equation.class);

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getDiscriminant_randomEquation_returnDiscriminant() throws NonQuadraticEquatioException {
		getDiscriminantTestHelper(1, 2, 1, 0);
		getDiscriminantTestHelper(2, 10, 2, 84);
		getDiscriminantTestHelper(2, 1, 2, -15);

		verify(mockEquation, times(3)).getA();
		verify(mockEquation, times(3)).getB();
		verify(mockEquation, times(3)).getC();
	}

	private void getDiscriminantTestHelper(double a, double b, double c, double expected)
			throws NonQuadraticEquatioException {
		when(mockEquation.getA()).thenReturn(a);
		when(mockEquation.getB()).thenReturn(b);
		when(mockEquation.getC()).thenReturn(c);
		sut = new EquationDiscriminantCalculator(mockEquation);
		double actual = sut.getDiscriminant();
		assertTrue(printTip(expected, actual), doublecomparision(expected, actual));

	}

	@Test(expected = NonQuadraticEquatioException.class)
	public void getDiscriminant_FirstDegreeEquation_ThrowExeption() throws NonQuadraticEquatioException {
		when(mockEquation.getA()).thenReturn(0.00);
		when(mockEquation.getB()).thenReturn(1.00);
		when(mockEquation.getC()).thenReturn(2.00);
		sut = new EquationDiscriminantCalculator(mockEquation);
		verify(mockEquation, times(1)).getA();
		verify(mockEquation, times(1)).getB();
		verify(mockEquation, times(1)).getC();
		sut.getDiscriminant();
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
