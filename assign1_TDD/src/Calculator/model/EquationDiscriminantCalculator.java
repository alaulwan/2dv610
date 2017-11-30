package Calculator.model;

public class EquationDiscriminantCalculator {
	private Equation equation;

	public EquationDiscriminantCalculator(Equation equation) {
		this.equation = equation;
	}

	public double getDiscriminant() {
		StandardCalculator SC = new StandardCalculator();
		AdvancedCalculator AC = new AdvancedCalculator();
		double A_mul_C = SC.mul(this.equation.getA(), this.equation.getC());
		return AC.power(this.equation.getB(), 2) - SC.mul(4, A_mul_C);
	}
}
