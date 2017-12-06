package Calculator;

import Calculator.View.EnglishView;
import Calculator.controller.Controller;
import Calculator.model.AdvancedCalculator;
import Calculator.model.Equation;
import Calculator.model.EquationDiscriminantCalculator;
import Calculator.model.FirstDegreeEquationCalculator;
import Calculator.model.QuadraticEquationCalculator;
import Calculator.model.StandardCalculator;

public class Program {

	public static void main(String[] args) {
		EnglishView EView = new EnglishView(System.out, System.in);
		Equation equation = new Equation(0, 0, 0);
		FirstDegreeEquationCalculator FDC = new FirstDegreeEquationCalculator(equation);
		QuadraticEquationCalculator QEC = new QuadraticEquationCalculator(equation, new StandardCalculator(),
				new AdvancedCalculator(), new EquationDiscriminantCalculator(equation));
		Controller controller = new Controller(EView, new StandardCalculator(), new AdvancedCalculator(), FDC, QEC,
				equation);
		while (controller.start());
	}

}
