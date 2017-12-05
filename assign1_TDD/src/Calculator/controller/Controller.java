package Calculator.controller;

import Calculator.View.EnglishView;

public class Controller {
	private EnglishView view;
	
	public Controller (EnglishView view) {
		this.view= view;
	}
	
	
	
	public double getNumberFromUser(int i) {
		view.askToNumberOrOperation(i);
		double number =Double.MIN_VALUE;
		while (number==Double.MIN_VALUE) {
			number = view.getUserInputNumber();
		}
		return number;
	}
	
	
}
