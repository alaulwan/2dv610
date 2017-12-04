package Calculator.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import Calculator.model.exeption.NonQuadraticEquatioException;

public class QuadraticEquatioCalculatorTest {
	private QuadraticEquationCalculator sut;
	private Equation mockEquation = mock(Equation.class);
	private StandardCalculator mockSC = mock(StandardCalculator.class);
	private AdvancedCalculator mockAC = mock(AdvancedCalculator.class);
	private EquationDiscriminantCalculator mockEDG = mock(EquationDiscriminantCalculator.class);

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void setEquation_RandomEquation_UpdateEquation() throws NonQuadraticEquatioException {
		EquationDiscriminantCalculator spyEDC = Mockito.spy(new EquationDiscriminantCalculator(mockEquation));
		sut = new QuadraticEquationCalculator(mockEquation, mockSC, mockAC, spyEDC);
		when(mockEquation.getA()).thenReturn(1.00);
		when(mockEquation.getB()).thenReturn(4.00);
		when(mockEquation.getC()).thenReturn(3.00);
		sut.setEquation(mockEquation);
		sut.startSolving();
		double actual = sut.getDiscriminant();
		double expected = 4.00;
		assertTrue(printTip(expected, actual), doublecomparision(expected, actual));
	}

	@Test
	public void startSolving_RandomEquation_GetSolutions() throws NonQuadraticEquatioException {
		sut = new QuadraticEquationCalculator(mockEquation, mockSC, mockAC, mockEDG);
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

		when(mockEquation.getA()).thenReturn(1.00);
		when(mockEquation.getB()).thenReturn(4.00);
		when(mockEquation.getC()).thenReturn(1.00);
		when(mockEDG.getDiscriminant()).thenReturn(0.00);
		when(mockSC.mul(2.00, 1.00)).thenReturn(2.00);
		when(mockAC.squareRoot(0.00)).thenReturn(0.00);
		when(mockSC.subtract(-4.00, 0.00)).thenReturn(-4.00);
		when(mockSC.sum(-4.00, 0.00)).thenReturn(-4.00);
		when(mockSC.divide(-4.00, 2.00)).thenReturn(-2.00);
		sut.startSolving();
		actual_1 = sut.getSolution1();
		actual_2 = sut.getSolution2();
		expected_1 = -2.00;
		expected_2 = -2.00;

		assertTrue(printTip(expected_1, actual_1), doublecomparision(expected_1, actual_1));
		assertTrue(printTip(expected_2, actual_2), doublecomparision(expected_2, actual_2));

		when(mockEDG.getDiscriminant()).thenReturn(-4.00);
		sut.startSolving();
		actual_1 = sut.getSolution1();
		actual_2 = sut.getSolution2();
		expected_1 = Double.MIN_VALUE;
		expected_2 = Double.MIN_VALUE;

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
