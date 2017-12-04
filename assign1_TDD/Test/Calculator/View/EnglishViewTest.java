package Calculator.View;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class EnglishViewTest {
	private EnglishView sut;
	PrintStream mockPrinter = mock(PrintStream.class);

	@Before
	public void setUp() throws Exception {
		sut= new EnglishView(mockPrinter);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void instructionPrint_Void_PrintInstruction() {
		sut.instructionPrint();
		verify(mockPrinter, times(1))
		.println("Welcome to calculator");
		verify(mockPrinter, times(1))
		.println("Enter:\n"
				+ "s: standard calculator\n"
				+ "d: advanced calculator\n"
				+ "f: First Degree Equation Calculator a.x + b = 0\n"
				+ "q: Quadratic Equatio Calculator a.x^2 + b.x + c = 0\n"
				+ "e: exit");
	}

}
