package model;

import java.util.List;

public class OrderParameter {
	
	private int maximumNumberOfSlicesToOrder;
	private List<Pizza> pizzasAvailable;
	
	public OrderParameter(int maximumNumberOfSlicesToOrder, List<Pizza> pizzasAvailable) {
		super();
		this.maximumNumberOfSlicesToOrder = maximumNumberOfSlicesToOrder;
		this.pizzasAvailable = pizzasAvailable;
	}

	public int getMaximumNumberOfSlicesToOrder() {
		return maximumNumberOfSlicesToOrder;
	}

	public void setMaximumNumberOfSlicesToOrder(int maximumNumberOfSlicesToOrder) {
		this.maximumNumberOfSlicesToOrder = maximumNumberOfSlicesToOrder;
	}

	public List<Pizza> getPizzasAvailable() {
		return pizzasAvailable;
	}

	public void setPizzasAvailable(List<Pizza> pizzasAvailable) {
		this.pizzasAvailable = pizzasAvailable;
	}
}
