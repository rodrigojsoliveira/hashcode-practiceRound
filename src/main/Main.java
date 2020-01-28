package main;

import java.io.FileNotFoundException;

import Services.FileIOService;
import Services.OrderService;
import model.Order;
import model.OrderParameter;

public class Main {

	public static void main(String[] args) {

		FileIOService fio = new FileIOService();

		OrderParameter op = null;

		try {
			op = fio.readInputFile("d_quite_big.in");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		OrderService orderService = new OrderService(op);

		Order order = orderService.prepareOrder();

		System.out.println(order.toString());

		try {
			fio.writeToFile(order);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
