// References researched:
// https://codeforces.com/blog/entry/47003
// https://www.techiedelight.com/subset-sum-problem/

package main;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import Services.FileIOService;
import Services.Solver;

public class Main implements Runnable {

	public static void main(String[] args) throws Exception {

		new Thread(null, new Main(), "Main", 1 << 26).start();

	}

	public void run() {

		FileIOService fio = new FileIOService();

		try {
			fio.readInputFile("a_example.in");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Solver solver = new Solver();
		Map<String, Boolean> lookup = new HashMap<>();

		if (solver.hasSubsetSum(fio.getPizzas(), fio.getPizzas().length - 1, fio.getSum(), lookup)) {
			try {
				fio.writeToFile(solver.getSubset());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				fio.writeToFile(solver.getSecondBestSubset(fio.getPizzas(), fio.getSum()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
