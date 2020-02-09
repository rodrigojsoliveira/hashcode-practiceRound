package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solver {

	private int[] pizzas;
	private int sum;
	private Map<String, Boolean> lookup = new HashMap<>();

	public void createSolutionTable(int[] pizzas, int sum) {

		this.pizzas = pizzas;
		this.sum = sum;

		for (int row = 0; row < pizzas.length; row++) {
			String key = row + "0";
			this.lookup.put(key, true);
		}

		for (int column = 1; column <= sum; column++) {
			String key = "0" + column;
			this.lookup.put(key, false);
		}

		for (int row = 1; row <= pizzas.length; row++) {
			for (int column = 1; column <= sum; column++) {
				if (pizzas[row - 1] > column) {
					this.lookup.put(Integer.toString(row) + Integer.toString(column),
							this.lookup.get(Integer.toString(row - 1) + Integer.toString(column)));
				} else {
					if (this.lookup.get(Integer.toString((row - 1)) + Integer.toString(column))) {
						this.lookup.put(Integer.toString(row) + Integer.toString(column),
								this.lookup.get(Integer.toString(row - 1) + Integer.toString(column)));
					} else {
						this.lookup.put(Integer.toString(row) + Integer.toString(column),
								this.lookup.get(Integer.toString(row - 1) + Integer.toString(column-pizzas[row-1])));
					}
				}
			}
		}
	}

	public boolean hasSubset() {
		
		if (this.lookup.get(Integer.toString(this.pizzas.length) + Integer.toString(this.sum))) {
			return true;
		} else {
			return false;
		}
	}

	public List<Integer> getSubset() {
		int row = this.pizzas.length;
		int column = this.sum;
		List<Integer> solution = new ArrayList<Integer>();

		while (row > 0 || column > 0) {
			if (this.lookup.get(Integer.toString(row) + Integer.toString(column)) == this.lookup.get(Integer.toString(row-1) + Integer.toString(column))) {
				row = row - 1;
			} else {
				solution.add(this.pizzas[row - 1]);
				column = column - this.pizzas[row - 1];
				row = row - 1;
			}
		}
		return solution;
	}

}
