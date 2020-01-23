package main;

import java.io.FileNotFoundException;

import Services.FileReadingService;
import Services.OrderService;
import model.OrderParameter;

public class Main {
	
	public static void main(String[] args) {
		
		FileReadingService frs = new FileReadingService();
		
		OrderParameter op = null;
		
		try {
			op = frs.readInputFile("e_also_big.in");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		OrderService orderService = new OrderService(op);
		
		System.out.println(orderService.prepareOrder().toString());
		
	}

}
