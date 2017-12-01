package Calculator.model;

public class FirstDegreeEquationCalculator {

	private double a, b, c;
	private double Solution;

	public FirstDegreeEquationCalculator(Equation equation) {

		a = equation.getA();
		b = equation.getB();
		c = equation.getC();

	}

	private void startSolving() {
		StandardCalculator SC = new StandardCalculator();
		Solution = SC.divide(-c, b);
	}

	public double getSolution() {
		this.startSolving();
		return Solution;
	}

}