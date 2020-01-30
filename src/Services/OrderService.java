package Services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Order;
import model.OrderParameter;
import model.Pizza;

public class OrderService {

	private final int MAX_SLICES;
	private final List<Pizza> AVAILABLE_PIZZAS;

	public OrderService(OrderParameter orderParameters) {
		super();
		this.MAX_SLICES = orderParameters.getMaximumNumberOfSlicesToOrder();
		this.AVAILABLE_PIZZAS = new ArrayList<>(orderParameters.getPizzasAvailable());
	}

	public Order prepareOrder() {

		List<Pizza> pizzas = new ArrayList<>();
		List<Pizza> finalOrder = null;
		int sum = MAX_SLICES;
		int score = 0;
		int bestScore = 0;
		int rotate = 0;

		while (rotate != AVAILABLE_PIZZAS.size() && sum != 0) {
			sum = MAX_SLICES;
			pizzas.clear();
			score = 0;
			for (int x = AVAILABLE_PIZZAS.size() - 1; x >= 0; x--) {
				if (AVAILABLE_PIZZAS.get(x).getSize() <= sum) {
					sum = sum - AVAILABLE_PIZZAS.get(x).getSize();
					pizzas.add(AVAILABLE_PIZZAS.get(x));
					score = score + AVAILABLE_PIZZAS.get(x).getSize();
				}
				if (sum == 0)
					break;
			}
			rotate = rotate + 1;
			Collections.rotate(AVAILABLE_PIZZAS, 1);
			if (score > bestScore) {
				bestScore = score;
				finalOrder = new ArrayList<>(pizzas);
			}
		}

		// Collections.reverse(finalOrder);
		Collections.sort(finalOrder);

		return new Order(finalOrder.size(), finalOrder);
	}

}
