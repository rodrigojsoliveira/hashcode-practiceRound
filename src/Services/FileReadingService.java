package Services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.OrderParameter;
import model.Pizza;

public class FileReadingService {

	public OrderParameter readInputFile(String fileName) throws FileNotFoundException {

		int linecount = 0;
		int maximumNumberOfSlices = 0;
		int typesOfPizza = 0;
		List<Pizza> pizzas = new ArrayList<>();
		File file = new File("C:\\Users\\Rodrigo\\Downloads\\" + fileName);
		Scanner s = new Scanner(file);

		while (s.hasNextLine()) {
			linecount += 1;
			String line = s.nextLine();
			String[] values = line.split(" ");

			if (linecount == 1) {
				maximumNumberOfSlices = Integer.parseInt(values[0]);
				typesOfPizza = Integer.parseInt(values[1]);
			}

			if (linecount == 2) {
				for (int x = 0; x < typesOfPizza; x++) {
					Pizza p = new Pizza(x, Integer.parseInt(values[x]));
					pizzas.add(p);
				}
			}
		}

		s.close();
	
		OrderParameter orderParameter = new OrderParameter(maximumNumberOfSlices, pizzas);
		
		return orderParameter;

	}

}
