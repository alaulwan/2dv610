package Calculator.model;

import Calculator.model.exeption.NonFirstDegreeEquatioException;

public class FirstDegreeEquationCalculator {

	private double a, b, c;
	private double Solution;

	public FirstDegreeEquationCalculator(Equation equation) {
		a = equation.getA();
		b = equation.getB();
		c = equation.getC();
	}

	private void startSolving() throws NonFirstDegreeEquatioException {
		if (a != 0 || b == 0) {
			throw new NonFirstDegreeEquatioException();
		}
		StandardCalculator SC = new StandardCalculator();
		Solution = SC.divide(-c, b);
	}

	public double getSolution() throws NonFirstDegreeEquatioException {
		this.startSolving();
		return Solution;
	}

	public void setB(double b) {
		this.b = b;
	}

	public void setC(double c) {
		this.c = c;
	}

}