package Calculator.controller;

import java.util.List;

import Calculator.View.EnglishView;

public class Controller {
	private EnglishView view;

	public Controller(EnglishView view) {
		this.view = view;
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
		return 0;
		
	}

}
