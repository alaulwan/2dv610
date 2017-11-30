package Calculator.model;

public class EquationDiscriminantCalculator {
	double a,b,c;
	
	public EquationDiscriminantCalculator(Equation equation) {
		a=equation.getA();
		b=equation.getB();
		c=equation.getC();
	}

	public double getDiscriminant() {
		StandardCalculator SC = new StandardCalculator();
		AdvancedCalculator AC = new AdvancedCalculator();
		double A_mul_C = SC.mul(a, c);
		return AC.power(b, 2) - SC.mul(4, A_mul_C);
	}
}
