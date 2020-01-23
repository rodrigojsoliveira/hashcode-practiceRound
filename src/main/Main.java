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
			op = frs.readInputFile("b_small.in");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		/*
		List<Pizza> pizzasAvailable = new ArrayList<Pizza>();
		pizzasAvailable.add(new Pizza(0,2));
		pizzasAvailable.add(new Pizza(1,5));
		pizzasAvailable.add(new Pizza(2,6));
		pizzasAvailable.add(new Pizza(3,8));
		
		OrderParameter orderParameters = new OrderParameter(17, pizzasAvailable);
		*/
		
		OrderService orderService = new OrderService(op);
		
		System.out.println(orderService.prepareOrder().toString());
		
	}

}
