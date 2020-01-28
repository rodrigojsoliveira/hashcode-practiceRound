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
		int bestSliceOrder = 0;
		int rotate = 0;

		while (rotate <= orderParameters.getPizzasAvailable().size()) {
			
			if (bestSliceOrder == orderParameters.getMaximumNumberOfSlicesToOrder()) {
				break;
			}
			
			for (int x=orderParameters.getPizzasAvailable().size() - 1; x > 0; x--) {
	
				slicesOrdered = orderParameters.getPizzasAvailable().get(x).getSize();
				pizzasToOrder.add(orderParameters.getPizzasAvailable().get(x));
	
				for (int y = x - 1; y >= 0; y--) {
	
					if (slicesOrdered + orderParameters.getPizzasAvailable().get(y).getSize() <= orderParameters
							.getMaximumNumberOfSlicesToOrder()) {
						slicesOrdered += orderParameters.getPizzasAvailable().get(y).getSize();
						pizzasToOrder.add(orderParameters.getPizzasAvailable().get(y));
					}
				}
	
				if (slicesOrdered > bestSliceOrder) {
					finalOrder = new ArrayList<>(pizzasToOrder);
					bestSliceOrder = slicesOrdered;
				}
				
				pizzasToOrder.clear();
			}
			
			Collections.rotate(orderParameters.getPizzasAvailable(), 1);
			rotate += 1;
		}
		
		//Collections.reverse(finalOrder);
		Collections.sort(finalOrder);

		return new Order(finalOrder.size(), finalOrder);
	}

}
