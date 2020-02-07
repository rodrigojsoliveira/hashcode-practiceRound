package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import Services.FileIOService;

public class Main {

	public static void main(String[] args) {

		FileIOService fio = new FileIOService();

		try {
			fio.readInputFile("d_quite_big.in");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Solver solver = new Solver();

		solver.createSolutionTable(fio.getPizzas(), fio.getSum());
		
		if (solver.hasSubset()) {
			ArrayList<Integer> result = (ArrayList<Integer>) solver.getSubset();
			Collections.sort(result);
			for (int x : result) {
				System.out.println(x + " ");
			}
		}
	
	}

}
