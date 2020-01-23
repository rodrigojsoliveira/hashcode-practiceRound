package Services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Order;
import model.OrderParameter;
import model.Pizza;

public class OrderService {

	private OrderParameter orderParameters;

	public OrderService(OrderParameter orderParameters) {
		super();
		this.orderParameters = orderParameters;
	}

	public Order prepareOrder() {

		List<Pizza> pizzasToOrder = new ArrayList<>();
		List<Pizza> finalOrder = null;
		int slicesOrdered = 0;
		int previousSlicesOrdered = 0;
		
		Collections.reverse(orderParameters.getPizzasAvailable());
		
		for (int x = 0; x < orderParameters.getPizzasAvailable().size(); x++ ) {
		
			for (Pizza p : orderParameters.getPizzasAvailable()) {
				if (p.getSize() <= orderParameters.getMaximumNumberOfSlicesToOrder()
						&& slicesOrdered + p.getSize() <= orderParameters.getMaximumNumberOfSlicesToOrder()) {
					slicesOrdered = slicesOrdered + p.getSize();
					pizzasToOrder.add(p);
				}
			}
			
			if (slicesOrdered == orderParameters.getMaximumNumberOfSlicesToOrder()) {
				break;
			} else if (slicesOrdered > previousSlicesOrdered) {
				previousSlicesOrdered = slicesOrdered;
				finalOrder = new ArrayList<>(pizzasToOrder);				
			}
			
			orderParameters.getPizzasAvailable().remove(orderParameters.getPizzasAvailable().size()-1);
			
			
		}
		

		Collections.reverse(finalOrder);

		Order order = new Order(pizzasToOrder.size(), finalOrder);

		return order;
	}

}
