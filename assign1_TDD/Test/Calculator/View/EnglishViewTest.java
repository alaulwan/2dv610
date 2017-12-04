package Calculator.View;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EnglishViewTest {
	private EnglishView sut;
	PrintStream mockPrinter = mock(PrintStream.class);

	@Before
	public void setUp() throws Exception {
		sut = new EnglishView(mockPrinter);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void instructionPrintTest() {
		sut.instructionPrint();
		verify(mockPrinter, times(1)).println("Welcome to calculator");
		verify(mockPrinter, times(1)).println("Enter:\n" + "s: standard calculator\n" + "d: advanced calculator\n"
				+ "f: First Degree Equation Calculator a.x + b = 0\n"
				+ "q: Quadratic Equatio Calculator a.x^2 + b.x + c = 0\n" + "e: exit");
	}

	@Test
	public void standardInstructionDisplayTest() {
		sut.standardInstructionDisplay();
		verify(mockPrinter, times(1)).println("Welcome to the standard calculator for (+,-,*,/,%) operations.");
	}

	@Test
	public void advancedInstructionDisplayTest() {
		sut.advancedInstructionDisplay();
		verify(mockPrinter, times(1))
				.println("Welcome to the advanced calculator for (square root, power) operations.");
	}

	@Test
	public void standardResultPrint_RandomDouble_PrintRightForm() {
		for (int i = 1; i < 100; i++) {
			double result = 3.0177;
			sut.standardResultPrint(result);
			verify(mockPrinter, times(i)).println("result: " + result);
		}
	}

	@Test
	public void askToNumberOrOperation_IntegersFrom0To100_PrintRightForm() {
		for (int i = 0; i < 100; i++) {
			sut.askToNumberOrOperation(i);
			switch (i) {
			case 1:
				verify(mockPrinter, times(1)).println("Enter the first number A:");
				break;
			case 2:
				verify(mockPrinter, times(1)).println("Enter the second number B:");
				break;
			case 3:
				verify(mockPrinter, times(1)).println("Enter the third number C:");
				break;
			case 0:
				verify(mockPrinter, times(1)).println("Enter the operation (+,-,*,/,%) or c to cancel: ");
				break;
			default:
				verify(mockPrinter, times(i - 3)).println("Enter the operation s:Square Root, p: power, c:cancel");
			}
		}

	}
}
