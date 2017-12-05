package Calculator.View;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class EnglishView {
	private PrintStream printer;
	private InputStream input;;

	public EnglishView(PrintStream p, InputStream in) {
		this.printer = p;
		this.input = in;
	}

	public void instructionPrint() {
		printer.println("Welcome to calculator");
		printer.println("Enter:\n" + "s: standard calculator\n" + "d: advanced calculator\n"
				+ "f: First Degree Equation Calculator a.x + b = 0\n"
				+ "q: Quadratic Equatio Calculator a.x^2 + b.x + c = 0\n" + "e: exit");
	}

	public void standardInstructionDisplay() {
		printer.println("Welcome to the standard calculator for (+,-,*,/,%) operations.");
	}

	public void advancedInstructionDisplay() {
		printer.println("Welcome to the advanced calculator for (square root, power) operations.");
	}

	public void standardResultPrint(double result) {
		printer.println("result: " + result);
	}

	public void askToNumberOrOperation(int i) {
		switch (i) {
		case 1:
			printer.println("Enter the first number A:");
			break;
		case 2:
			printer.println("Enter the second number B:");
			break;
		case 3:
			printer.println("Enter the third number C:");
			break;
		case 0:
			printer.println("Enter the operation (+,-,*,/,%) or c to cancel: ");
			break;
		default:
			printer.println("Enter the operation s:Square Root, p: power, c:cancel");
		}

	}

	public void printText(String text) {
		printer.println(text);
	}

	public char getUserInputChar() {
		String text = "";
		while (text.replaceAll("\\s+", "").isEmpty()) {
			text = getInput();
		}
		return text.charAt(0);
	}

	public void waitToEnter() {
		printer.println("Press Enter to continue...");
		getInput();
	}

	public String getInput() {
		StringBuilder sb = new StringBuilder();
		try {
			input.skip(input.available());
			char c = '\n';
			c = (char) input.read();
			sb.append(c);
			int a = input.available() - 2;
			while (a > 0) {
				c = (char) input.read();
				sb.append(c);
				a--;
			}
			input.skip(input.available());
			return sb.toString();
		} catch (IOException e) {
			return sb.toString();
		}
	}

}
