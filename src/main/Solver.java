package main;

import java.util.ArrayList;
import java.util.List;

public class Solver {

	private int[] pizzas;
	private int sum;
	private boolean[][] table;

	public void createSolutionTable(int[] pizzas, int sum) {
		
		this.pizzas = pizzas;
		this.sum = sum;

		this.table = new boolean[pizzas.length + 1][sum + 1];

		for (int row = 0; row < pizzas.length; row++) {
			this.table[row][0] = true;
		}

		for (int column = 1; column <= sum; column++) {
			this.table[0][column] = false;
		}

		for (int row = 1; row <= pizzas.length; row++) {
			for (int column = 1; column <= sum; column++) {
				if (pizzas[row - 1] > column) {
					this.table[row][column] = this.table[row - 1][column];
				} else {
					if (this.table[row - 1][column]) {
						this.table[row][column] = this.table[row - 1][column];
					} else {
						this.table[row][column] = this.table[row - 1][column - pizzas[row - 1]];
					}
				}
			}
		}
	}

	public boolean hasSubset() {
		if (this.table[this.pizzas.length][this.sum]) {
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
			if (this.table[row][column] == this.table[row-1][column]) {
				row = row-1;
			} else {
				solution.add(this.pizzas[row-1]);
				column = column-this.pizzas[row-1];
				row=row-1;
			}
		}
		return solution;
	}

}
