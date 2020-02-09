// Resources:
// https://codeforces.com/blog/entry/47003
// https://www.techiedelight.com/subset-sum-problem/

package main;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import Services.FileIOService;

public class Main implements Runnable {

	public static void main(String[] args) throws Exception {

		new Thread(null, new Main(), "Main", 1 << 26).start();

	}

	public void run() {

		FileIOService fio = new FileIOService();

		try {
			fio.readInputFile("d_quite_big.in");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Solver solver2 = new Solver();
		Map<String, Boolean> lookup = new HashMap<>();

		if (solver2.subsetSum(fio.getPizzas(), fio.getPizzas().length - 1, fio.getSum(), lookup)) {
			try {
				fio.writeToFile(solver2.getResult());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
