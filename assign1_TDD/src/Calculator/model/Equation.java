package Calculator.model;

public class Equation {
	double a, b, c;

	public Equation(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public double getC() {
		return c;
	}

	public void setABC(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

}
