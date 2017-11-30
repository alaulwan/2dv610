package Calculator.model;

public class FirstDegreeEquationCalculator {

	private Equation equation;
	private double Solution;

	public FirstDegreeEquationCalculator(Equation equation) {

		this.equation = equation;

	}

	private void startSolving() {
		StandardCalculator SC = new StandardCalculator();
		Solution = SC.divide(-equation.getC(), equation.getB());
	}

	public double getSolution() {
		this.startSolving();
		return Solution;
	}

}