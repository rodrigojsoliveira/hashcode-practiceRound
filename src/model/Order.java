package model;

import java.util.List;

public class Order {

	private int numberOfPizzasToOrder;
	private List<Pizza> typesOfPizzasToOrder;

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

	@Override
	public String toString() {
		String pizzaTypes = "";
		int totalSlices = 0;
		for (Pizza p : typesOfPizzasToOrder) {
			pizzaTypes = pizzaTypes + p.getType() + " ";
			totalSlices = totalSlices + p.getSize();
		}
		return ("Number of pizzas to order: " + numberOfPizzasToOrder + "\nTypes of pizzas to order: " + pizzaTypes
				+ "\nNumber of ordered slices: " + totalSlices);
	}
}