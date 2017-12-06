package Calculator.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Calculator.View.EnglishView;
import Calculator.model.StandardCalculator;

public class ControllerTest {
	private Controller sut;
	EnglishView mockView = mock(EnglishView.class);
	StandardCalculator mockSc = mock(StandardCalculator.class);
	Controller spySut ;

	@Before
	public void setUp() throws Exception {
		sut = new Controller(mockView, mockSc);
		spySut = Mockito.spy(sut);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getNumberFromUser_ShouldReturnDouble() {
		when(mockView.getUserInputNumber()).thenReturn(3.03);
		double actual = sut.getNumberFromUser(1);
		double expected = 3.03;
		assertTrue(printTip(expected, actual), doublecomparision(expected, actual));
		verify(mockView, times(1)).askToNumberOrOperation(1);
		verify(mockView, times(1)).getUserInputNumber();

	}

	@Test
	public void getOperationFromUser_ShouldOperation() {
		{
			when(mockView.getUserInputChar()).thenReturn('s').thenReturn('+');
			char actual = sut.getOperationFromUser(Arrays.asList('+', '-', '*', '/', '%', 'c'), false);
			char expected = '+';
			assertEquals(actual, expected);
			verify(mockView, times(2)).askToNumberOrOperation(0);
			verify(mockView, times(0)).askToNumberOrOperation(-1);
			verify(mockView, times(2)).getUserInputChar();
		}
		{
			when(mockView.getUserInputChar()).thenReturn('k').thenReturn('s');
			char actual = sut.getOperationFromUser(Arrays.asList('s', 'p', 'c'), true);
			char expected = 's';
			assertEquals(actual, expected);
			verify(mockView, times(2)).askToNumberOrOperation(0);
			verify(mockView, times(2)).askToNumberOrOperation(-1);
			verify(mockView, times(4)).getUserInputChar();
		}
	}
	
	@Test
	public void standardCalculator_GetTwoNumberAndOperationThenCalculateTheResult() {
		doReturn(5.00).when(spySut).getNumberFromUser(1);
		doReturn(4.00).when(spySut).getNumberFromUser(2);
		//Case operations: +, -, *, /, %, c, or others
		doReturn('+').doReturn('-').doReturn('*').
		doReturn('/').doReturn('%').doReturn('c').
		doReturn('k').when(spySut).getOperationFromUser(Arrays.asList('+', '-', '*', '/', '%', 'c'), false);
		
		when(mockSc.sum(5.00, 4.00)).thenReturn(5.00 + 4.00);
		when(mockSc.subtract(5.00, 4.00)).thenReturn(5.00 - 4.00);
		when(mockSc.mul(5.00, 4.00)).thenReturn(5.00 * 4.00);
		when(mockSc.divide(5.00, 4.00)).thenReturn(5.00 / 4.00);
		when(mockSc.mod(5.00, 4.00)).thenReturn(5.00 % 4.00);
		double [] expectedArray = {9.00, 1.00, 20.00, 1.25, 1, Double.MIN_VALUE, Double.MIN_VALUE };
		for(int i=0; i<7 ; i++) {
			double actual = spySut.standardCalculator();
			double expected = expectedArray[i];
			assertTrue(printTip(expected, actual), doublecomparision(expected, actual));
			verify(mockView, times(i+1)).standardInstructionDisplay();
		}
		
		//Case divider is zero
		doReturn(0.00).when(spySut).getNumberFromUser(2);
		doReturn('/').doReturn('%').when(spySut).getOperationFromUser(Arrays.asList('+', '-', '*', '/', '%', 'c'), false);
		when(mockSc.divide(5.00, 0.00)).thenThrow(new IllegalArgumentException("Number2 'divisor' is 0"));	
		double actual = spySut.standardCalculator();
		double expected = Double.MIN_VALUE;
		assertTrue(printTip(expected, actual), doublecomparision(expected, actual));
		verify(mockView, times(1)).printText("Error*****"+ "Number2 'divisor' is 0" +"*****\n");
		when(mockSc.mod(5.00, 0.00)).thenThrow(new IllegalArgumentException("Number2 'divisor' is 0"));
		actual = spySut.standardCalculator();
		expected = Double.MIN_VALUE;
		assertTrue(printTip(expected, actual), doublecomparision(expected, actual));
		verify(mockView, times(1)).printText("Error*****"+ "Number2 'divisor' is 0" +"*****\n");
		
		//Case user 'c' for number1 or number2 to cancel:
		doReturn('-').when(spySut).getOperationFromUser(Arrays.asList('+', '-', '*', '/', '%', 'c'), false);
		doReturn(Double.MAX_VALUE).when(spySut).getNumberFromUser(1);
		doReturn(4.00).when(spySut).getNumberFromUser(2);
		when(mockSc.subtract(Double.MAX_VALUE, 4.00)).thenReturn(Double.MAX_VALUE - 4.00);
		actual = spySut.standardCalculator();
		expected = Double.MIN_VALUE;
		assertTrue(printTip(expected, actual), doublecomparision(expected, actual));
		
		doReturn(5.00).when(spySut).getNumberFromUser(1);
		doReturn(Double.MAX_VALUE).when(spySut).getNumberFromUser(2);
		when(mockSc.subtract(5.00, Double.MAX_VALUE)).thenReturn(5.00 - Double.MAX_VALUE);
		actual = spySut.standardCalculator();
		expected = Double.MIN_VALUE;
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
