package Calculator.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Calculator.model.exeption.NonQuadraticEquatioException;

public class QuadraticEquatioCalculatorTest {
	private QuadraticEquatioCalculator sut;
	private Equation mockEquation = mock(Equation.class);
	private StandardCalculator mockSC = mock(StandardCalculator.class);
	private AdvancedCalculator mockAC = mock(AdvancedCalculator.class);
	private EquationDiscriminantCalculator mockEDG = mock(EquationDiscriminantCalculator.class);

	@Before
	public void setUp() throws Exception {
		sut = new QuadraticEquatioCalculator(mockEquation, mockSC, mockAC, mockEDG);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void startSolving_RandomEquation_GetSolutions() throws NonQuadraticEquatioException {
		when(mockEquation.getA()).thenReturn(1.00);
		when(mockEquation.getB()).thenReturn(4.00);
		when(mockEquation.getC()).thenReturn(3.00);
		when(mockEDG.getDiscriminant()).thenReturn(4.00);
		when(mockSC.mul(2.00, 1.00)).thenReturn(2.00);
		when(mockAC.squareRoot(4.00)).thenReturn(2.00);
		when(mockSC.subtract(-4.00, 2.00)).thenReturn(-6.00);
		when(mockSC.sum(-4.00, 2.00)).thenReturn(-2.00);
		when(mockSC.divide(-6.00, 2.00)).thenReturn(-3.00);
		when(mockSC.divide(-2.00, 2.00)).thenReturn(-1.00);
		sut.startSolving();
		double actual_1 = sut.getSolution1();
		double actual_2 = sut.getSolution2();
		double expected_1 = -3.00;
		double expected_2 = -1.00;
		
		assertTrue(printTip(expected_1, actual_1), doublecomparision(expected_1, actual_1));
		assertTrue(printTip(expected_2, actual_2), doublecomparision(expected_2, actual_2));
		
		
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
