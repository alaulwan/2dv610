package Calculator.controller;

import java.util.Arrays;
import java.util.List;

import Calculator.View.EnglishView;
import Calculator.model.AdvancedCalculator;
import Calculator.model.Equation;
import Calculator.model.FirstDegreeEquationCalculator;
import Calculator.model.QuadraticEquationCalculator;
import Calculator.model.StandardCalculator;
import Calculator.model.exeption.NonFirstDegreeEquatioException;
import Calculator.model.exeption.NonQuadraticEquatioException;

public class Controller {
	private EnglishView view;
	private StandardCalculator sc;
	private AdvancedCalculator AC;
	private FirstDegreeEquationCalculator FDC;
	private QuadraticEquationCalculator QEC;
	private Equation equation;

	public Controller(EnglishView view, StandardCalculator sc, AdvancedCalculator ac, FirstDegreeEquationCalculator FDC,
			QuadraticEquationCalculator QEC, Equation equation) {
		this.view = view;
		this.sc = sc;
		this.AC = ac;
		this.FDC = FDC;
		this.QEC = QEC;
		this.equation = equation;
	}
	
	public boolean start() {
		view.instructionPrint();
		char input = view.getUserInputChar();

		if (input == 's') {
			double result = standardCalculator();
			if (result != Double.MIN_VALUE) {
				view.standardResultPrint(result);
				view.waitToEnter();
			}

		} else if (input == 'd') {
			double result = advancedCalculator();
			if (result != Double.MIN_VALUE) {
				view.standardResultPrint(result);
				view.waitToEnter();
			}
		} else if (input == 'f') {
			double result = FirstDegreeEquationCalculator();
			if (result != Double.MIN_VALUE) {
				view.standardResultPrint(result);
				view.waitToEnter();
			}
		} else if (input == 'q') {
			double result = QuadraticEquatioCalculator();
			if (result != Double.MIN_VALUE) {
				double numberOfSolution = QEC.getNumberOfSolutions();
				double result1 = QEC.getSolution1();
				double result2 = QEC.getSolution2();
				if (numberOfSolution == 2) {
					view.standardResultPrint(result1);
					view.standardResultPrint(result2);
				} else if (numberOfSolution == 1) {
					view.standardResultPrint(result1);
				} else {
					view.printText("*****No Solution*****");
				}
				view.waitToEnter();

			}

		}
		return input != 'e';

	}

	public double standardCalculator() {
		view.standardInstructionDisplay();
		double result = Double.MIN_VALUE;
		double number1 = Double.MIN_VALUE;
		double number2 = Double.MIN_VALUE;
		char operation = Character.MIN_VALUE;

		number1 = getNumberFromUser(1);
		if (number1 == Double.MAX_VALUE)
			return Double.MIN_VALUE;

		operation = getOperationFromUser(Arrays.asList('+', '-', '*', '/', '%', 'c'), false);
		if (operation == 'c')
			return Double.MIN_VALUE;

		number2 = getNumberFromUser(2);
		if (number2 == Double.MAX_VALUE)
			return Double.MIN_VALUE;

		switch (operation) {
		case '+':
			result = sc.sum(number1, number2);
			break;
		case '-':
			result = sc.subtract(number1, number2);
			break;
		case '*':
			result = sc.mul(number1, number2);
			break;
		case '/':
			try {
				result = sc.divide(number1, number2);
			} catch (IllegalArgumentException e) {
				view.printText("Error*****" + e.getMessage() + "*****\n");
				return Double.MIN_VALUE;
			}
			break;
		case '%':
			try {
				result = sc.mod(number1, number2);
			} catch (IllegalArgumentException e) {
				view.printText(e.getMessage() + "\n");
				return Double.MIN_VALUE;
			}
			break;
		}
		return result;
	}

	public double advancedCalculator() {
		view.advancedInstructionDisplay();
		double result = Double.MIN_VALUE;
		double number1 = Double.MIN_VALUE;
		double number2 = Double.MIN_VALUE;
		char operation = Character.MIN_VALUE;

		number1 = getNumberFromUser(1);
		if (number1 == Double.MAX_VALUE)
			return Double.MIN_VALUE;

		operation = getOperationFromUser(Arrays.asList('s', 'p', 'c'), true);
		if (operation == 'c')
			return Double.MIN_VALUE;

		if (operation == 's') {
			try {
				result = AC.squareRoot(number1);
			} catch (IllegalArgumentException e) {
				view.printText("Error*****" + e.getMessage() + "*****\n");
				return Double.MIN_VALUE;
			}

		} else {
			number2 = getNumberFromUser(2);
			if (number2 == Double.MAX_VALUE)
				return Double.MIN_VALUE;
			result = AC.power(number1, number2);
		}

		return result;
	}

	public double FirstDegreeEquationCalculator() {
		double result = Double.MIN_VALUE;
		double number1 = Double.MIN_VALUE;
		double number2 = Double.MIN_VALUE;

		number1 = getNumberFromUser(1);
		if (number1 == Double.MAX_VALUE)
			return Double.MIN_VALUE;

		number2 = getNumberFromUser(2);
		if (number2 == Double.MAX_VALUE)
			return Double.MIN_VALUE;

		FDC.setB(number1);
		FDC.setC(number2);
		try {
			result = FDC.getSolution();
		} catch (NonFirstDegreeEquatioException e) {
			view.printText("Error*****Non First Degree Equatio*****\n");
			return Double.MIN_VALUE;
		}
		return result;
	}

	public double QuadraticEquatioCalculator() {
		double number1 = Double.MIN_VALUE;
		double number2 = Double.MIN_VALUE;
		double number3 = Double.MIN_VALUE;

		number1 = getNumberFromUser(1);
		if (number1 == Double.MAX_VALUE)
			return Double.MIN_VALUE;

		number2 = getNumberFromUser(2);
		if (number2 == Double.MAX_VALUE)
			return Double.MIN_VALUE;

		number3 = getNumberFromUser(3);
		if (number3 == Double.MAX_VALUE)
			return Double.MIN_VALUE;
		equation.setABC(number1, number2, number3);
		QEC.setEquation(equation);
		try {
			QEC.startSolving();
		} catch (NonQuadraticEquatioException e) {
			view.printText("Error*****Non Quadratic Equatio*****\n");
			return Double.MIN_VALUE;
		}
		return 1;

	}

	public double getNumberFromUser(int i) {
		view.askToNumberOrOperation(i);
		double number = Double.MIN_VALUE;
		while (number == Double.MIN_VALUE) {
			number = view.getUserInputNumber();
		}
		return number;
	}

	public char getOperationFromUser(List<Character> list, boolean isAdvanced) {
		char operation = '0';
		while (!list.contains(operation)) {
			if (isAdvanced)
				view.askToNumberOrOperation(-1);
			else
				view.askToNumberOrOperation(0);
			operation = view.getUserInputChar();
		}
		return operation;
	}

}
