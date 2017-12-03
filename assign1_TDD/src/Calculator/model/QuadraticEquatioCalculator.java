package Calculator.model;

import Calculator.model.exeption.NonQuadraticEquatioException;

public class QuadraticEquatioCalculator {
	private Equation equation;
	StandardCalculator SC;
	AdvancedCalculator AC;
	EquationDiscriminantCalculator EDC;
	
	private double Discriminant, Solution1, Solution2;
	

	private int numberOfSolutions;
	
	public QuadraticEquatioCalculator(Equation equation, StandardCalculator SC, AdvancedCalculator AC, EquationDiscriminantCalculator EDC) {
		this.SC = SC;
		this.AC= AC;
		this.EDC = EDC;
		this.equation=equation;
	}
	
	public void startSolving() throws NonQuadraticEquatioException{
		this.Discriminant= EDC.getDiscriminant();
		if (Discriminant > 0) {
			numberOfSolutions=2;
			Solution1 = SC.divide(SC.subtract(-equation.getB(), AC.squareRoot(Discriminant)), SC.mul(2, equation.getA()));
			Solution2 = SC.divide(SC.sum(-equation.getB(), AC.squareRoot(Discriminant)), SC.mul(2, equation.getA()));
		}
		else if (Discriminant == 0) {
			numberOfSolutions=1;
			Solution1 = SC.divide(SC.subtract(-equation.getB(), AC.squareRoot(Discriminant)), SC.mul(2, equation.getA()));
			Solution2 = SC.divide(SC.sum(-equation.getB(), AC.squareRoot(Discriminant)), SC.mul(2, equation.getA()));
		}
		else if (Discriminant == 0) {
			numberOfSolutions=1;
			Solution1 = SC.divide(SC.subtract(-equation.getB(), AC.squareRoot(Discriminant)), SC.mul(2, equation.getA()));
			Solution2 = SC.divide(SC.sum(-equation.getB(), AC.squareRoot(Discriminant)), SC.mul(2, equation.getA()));
		}
		else {
			numberOfSolutions=0;
			Solution1 = Double.MIN_VALUE;
			Solution2 = Solution1;
		}
	}

	public double getSolution1() {
		return Solution1;
	}

	public double getSolution2() {
		return Solution2;
	}
	
}
