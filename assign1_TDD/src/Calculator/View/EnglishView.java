package Calculator.View;

import java.io.PrintStream;

public class EnglishView {
	private PrintStream printer;
	
	public EnglishView(PrintStream p) {
		this.printer = p;
	}
	
	public void instructionPrint() {
		printer.println("Welcome to calculator");
		printer.println("Enter:\n"
				+ "s: standard calculator\n"
				+ "d: advanced calculator\n"
				+ "f: First Degree Equation Calculator a.x + b = 0\n"
				+ "q: Quadratic Equatio Calculator a.x^2 + b.x + c = 0\n"
				+ "e: exit");
	}
}
