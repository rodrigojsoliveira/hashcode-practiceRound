// Resources:
// https://codeforces.com/blog/entry/47003
// https://www.techiedelight.com/subset-sum-problem/

package main;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import Services.FileIOService;

public class Main implements Runnable {

	public static void main(String[] args) throws Exception {

		new Thread(null, new Main(), "Main").start();

	}

	public void run() {

		FileIOService fio = new FileIOService();

		try {
			fio.readInputFile("b_small.in");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Solver2 solver2 = new Solver2();
		Map<String, Boolean> lookup = new HashMap<>();

		System.out.println(solver2.subsetSum(fio.getPizzas(), fio.getPizzas().length - 1, fio.getSum(), lookup));

		Collections.sort(solver2.getResultList());
		String s = "";
		
		for (Integer a : solver2.getResultList()) {
			s = s + Integer.toString(a) + " ";
		}
		System.out.println(s);

	}

}
