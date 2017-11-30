package Calculator.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class EquationDiscriminantCalculatorTest {
	private EquationDiscriminantCalculator sut;
	private Equation mockEquation = mock(Equation.class);

	@Before
	public void setUp() throws Exception {
		sut = new EquationDiscriminantCalculator(mockEquation);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getDiscriminant_randomEquation_returnDiscriminant() {
		when(mockEquation.getA()).thenReturn(1.00);
		when(mockEquation.getB()).thenReturn(2.00);
		when(mockEquation.getC()).thenReturn(1.00);
		double actual = sut.getDiscriminant();
		double expected = 0;
		assertTrue(printTip(expected, actual), doublecomparision(expected, actual));
		
		when(mockEquation.getA()).thenReturn(2.00);
		when(mockEquation.getB()).thenReturn(10.00);
		when(mockEquation.getC()).thenReturn(2.00);
		actual = sut.getDiscriminant();
		expected = 84;
		assertTrue(printTip(expected, actual), doublecomparision(expected, actual));
		
		when(mockEquation.getA()).thenReturn(2.00);
		when(mockEquation.getB()).thenReturn(1.00);
		when(mockEquation.getC()).thenReturn(2.00);
		actual = sut.getDiscriminant();
		expected = -15;
		assertTrue(printTip(expected, actual), doublecomparision(expected, actual));
		
		verify(mockEquation, times(3)).getA();
		verify(mockEquation, times(3)).getB();
		verify(mockEquation, times(3)).getC();

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
