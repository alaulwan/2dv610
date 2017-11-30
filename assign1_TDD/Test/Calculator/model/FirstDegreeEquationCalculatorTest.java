package Calculator.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FirstDegreeEquationCalculatorTest {
	private FirstDegreeEquationCalculator sut;
	private Equation mockEquation = mock(Equation.class);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getSolution_RandomEquation_ReturnSolution() {
		getSolutionTestHelper(8, 16, -2);
		getSolutionTestHelper(-16, 8, 0.5);
		getSolutionTestHelper(5, 0, 0);

		verify(mockEquation, times(3)).getB();
		verify(mockEquation, times(3)).getC();
	}

	private void getSolutionTestHelper(double b, double c, double expected) {
		when(mockEquation.getB()).thenReturn(b);
		when(mockEquation.getC()).thenReturn(c);
		sut = new FirstDegreeEquationCalculator(mockEquation);
		double actual = sut.getSolution();
		assertTrue(printTip(expected, actual), doublecomparision(expected, actual));

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
