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
		int maximumPossibleSlicesOrdered = 0;

		for (int x=orderParameters.getPizzasAvailable().size() - 1; x>1; x--) {

			slicesOrdered = orderParameters.getPizzasAvailable().get(x).getSize();
			pizzasToOrder.add(orderParameters.getPizzasAvailable().get(x));

			for (int y = x - 1; y >= 0; y--) {

				if (slicesOrdered + orderParameters.getPizzasAvailable().get(y).getSize() <= orderParameters
						.getMaximumNumberOfSlicesToOrder()) {
					slicesOrdered += orderParameters.getPizzasAvailable().get(y).getSize();
					pizzasToOrder.add(orderParameters.getPizzasAvailable().get(y));
				}
			}

			if (slicesOrdered > maximumPossibleSlicesOrdered) {
				finalOrder = new ArrayList<>(pizzasToOrder);
				maximumPossibleSlicesOrdered = slicesOrdered;
			}
			
			pizzasToOrder.clear();

		}
		
		Collections.reverse(finalOrder);

		return new Order(finalOrder.size(), finalOrder);
	}

}
