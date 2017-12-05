package Calculator.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Calculator.View.EnglishView;

public class ControllerTest {
	private Controller sut;
	EnglishView mockView = mock(EnglishView.class);

	@Before
	public void setUp() throws Exception {
		sut = new Controller(mockView);
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
