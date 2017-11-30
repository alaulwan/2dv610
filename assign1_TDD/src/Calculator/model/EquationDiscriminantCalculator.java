package Calculator.model;

import Calculator.model.exeption.NonQuadraticEquatioException;

public class EquationDiscriminantCalculator {
	double a;
	double b;
	double c;

	public EquationDiscriminantCalculator(Equation equation) {
		a = equation.getA();
		b = equation.getB();
		c = equation.getC();
	}

	public double getDiscriminant() throws NonQuadraticEquatioException {
		if (a == 0) {
			throw new NonQuadraticEquatioException();
		}
		StandardCalculator SC = new StandardCalculator();
		AdvancedCalculator AC = new AdvancedCalculator();
		double A_mul_C = SC.mul(a, c);
		return AC.power(b, 2) - SC.mul(4, A_mul_C);
	}
}
