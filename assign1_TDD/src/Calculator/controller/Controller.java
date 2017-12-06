package Calculator.controller;

import java.util.Arrays;
import java.util.List;

import Calculator.View.EnglishView;
import Calculator.model.StandardCalculator;

public class Controller {
	private EnglishView view;
	private StandardCalculator sc;

	public Controller(EnglishView view, StandardCalculator sc) {
		this.view = view;
		this.sc= sc;
	}
	
	public double standardCalculator() {
		view.standardInstructionDisplay();
		double result = Double.MIN_VALUE;
		double number1 = Double.MIN_VALUE;
		double number2 = Double.MIN_VALUE;
		char operation = Character.MIN_VALUE;
		
		
		number1 = getNumberFromUser(1);
		if (number1== Double.MAX_VALUE)
			return Double.MIN_VALUE;

		operation = getOperationFromUser(Arrays.asList ('+','-','*','/','%','c'), false);
		if (operation== 'c')
			return Double.MIN_VALUE;

		number2 = getNumberFromUser(2);
		if (number2== Double.MAX_VALUE)
			return Double.MIN_VALUE;

		switch (operation) {
		case '+': result = sc.sum(number1, number2);
			break;
		case '-': result = sc.subtract(number1, number2);
			break;
		case '*': result = sc.mul(number1, number2);
			break;
		case '/': try {
				result = sc.divide(number1, number2);
			} catch (IllegalArgumentException e) {
				view.printText("Error*****"+ e.getMessage()+"*****\n");
				return Double.MIN_VALUE;
			}
			break;
		case '%': try {
				result = sc.mod(number1, number2);
			} catch (IllegalArgumentException e) {
				view.printText(e.getMessage()+"\n");
				return Double.MIN_VALUE;
			}
			break;
		}
		return result;
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
