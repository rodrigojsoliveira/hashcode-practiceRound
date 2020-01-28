package model;

import java.util.List;

public class Order {

	private int numberOfPizzasToOrder;
	private List<Pizza> typesOfPizzasToOrder;
	private String pizzaTypes = "";
	private int totalSlices = 0;

	public Order(int numberOfPizzasToOrder, List<Pizza> typesOfPizzasToOrder) {
		super();
		this.numberOfPizzasToOrder = numberOfPizzasToOrder;
		this.typesOfPizzasToOrder = typesOfPizzasToOrder;
	}

	public int getNumberOfPizzasToOrder() {
		return numberOfPizzasToOrder;
	}

	public void setNumberOfPizzasToOrder(int numberOfPizzasToOrder) {
		this.numberOfPizzasToOrder = numberOfPizzasToOrder;
	}

	public List<Pizza> getTypesOfPizzasToOrder() {
		return typesOfPizzasToOrder;
	}

	public void setTypesOfPizzasToOrder(List<Pizza> typesOfPizzasToOrder) {
		this.typesOfPizzasToOrder = typesOfPizzasToOrder;
	}
	
	private void calculateResults() {
		if (pizzaTypes == "" && totalSlices == 0) {
			for (Pizza p : typesOfPizzasToOrder) {
				pizzaTypes = pizzaTypes + p.getType() + " ";
				totalSlices = totalSlices + p.getSize();
			}
		}
	}

	@Override
	public String toString() {
		calculateResults();
		return ("Number of pizzas to order: " + this.getNumberOfPizzasToOrder() + "\nTypes of pizzas to order: " + this.pizzaTypes
				+ "\nNumber of ordered slices: " + this.totalSlices);
	}
	
	public String toText() {
		calculateResults();
		
		return this.getNumberOfPizzasToOrder() + "\n" + this.pizzaTypes;  
	}
}
