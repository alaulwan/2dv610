package Calculator.model;

import Calculator.model.exeption.NonQuadraticEquatioException;

public class QuadraticEquationCalculator {
	private Equation equation;
	StandardCalculator SC;
	AdvancedCalculator AC;
	EquationDiscriminantCalculator EDC;

	private double Discriminant, Solution1, Solution2;

	private int numberOfSolutions;

	public QuadraticEquationCalculator(Equation equation, StandardCalculator SC, AdvancedCalculator AC,
			EquationDiscriminantCalculator EDC) {
		this.SC = SC;
		this.AC = AC;
		this.EDC = EDC;
		this.equation = equation;
	}

	public void startSolving() throws NonQuadraticEquatioException {
		this.Discriminant = EDC.getDiscriminant();
		if (getDiscriminant() > 0) {
			numberOfSolutions = 2;
			firstSolution();
			secondSolution();
		}

		else if (getDiscriminant() == 0) {
			numberOfSolutions = 1;
			firstSolution();
			secondSolution();
		} else {
			numberOfSolutions = 0;
			Solution1 = Double.MIN_VALUE;
			Solution2 = Solution1;
		}
	}

	private void firstSolution() {
		Solution1 = SC.divide(SC.subtract(-equation.getB(), AC.squareRoot(Discriminant)), SC.mul(2, equation.getA()));
	}

	private void secondSolution() {
		if (getNumberOfSolutions() == 1) {
			Solution2 = Solution1;
			return;
		}
		Solution2 = SC.divide(SC.sum(-equation.getB(), AC.squareRoot(Discriminant)), SC.mul(2, equation.getA()));
	}

	public double getSolution1() {
		return Solution1;
	}

	public double getSolution2() {
		return Solution2;
	}

	public int getNumberOfSolutions() {
		return numberOfSolutions;
	}

	public double getDiscriminant() {
		return Discriminant;
	}

	public void setEquation(Equation equation) {
		this.equation = equation;
		this.EDC.setA(equation.getA());
		this.EDC.setB(equation.getB());
		this.EDC.setC(equation.getC());
	}

}
