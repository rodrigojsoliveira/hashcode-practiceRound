package Services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileIOService {

	private String fileName;
	private int[] pizzas;
	private int sum = 0;

	public int[] getPizzas() {
		return pizzas;
	}

	public int getSum() {
		return sum;
	}

	public void readInputFile(String fileName) throws FileNotFoundException {

		int linecount = 0;
		int numberOfPizzas = 0;
		File file = new File(fileName);
		Scanner s = new Scanner(file);

		this.fileName = fileName;

		while (s.hasNextLine()) {
			linecount += 1;
			String line = s.nextLine();
			String[] values = line.split(" ");

			if (linecount == 1) {
				this.sum = Integer.parseInt(values[0]);
				numberOfPizzas = Integer.parseInt(values[1]);
			}

			if (linecount == 2) {
				this.pizzas = new int[numberOfPizzas];
				for (int x = 0; x < numberOfPizzas; x++) {
					this.pizzas[x] = Integer.parseInt(values[x]);
				}
			}
		}

		s.close();

	}

//	public void writeToFile(Order order) throws UnsupportedEncodingException, FileNotFoundException, IOException {
//
//		String newName = this.fileName.replace(".in", ".out");
//
//		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newName), "utf-8"));
//		writer.write(order.toText());
//		writer.close();
//
//	}

}
