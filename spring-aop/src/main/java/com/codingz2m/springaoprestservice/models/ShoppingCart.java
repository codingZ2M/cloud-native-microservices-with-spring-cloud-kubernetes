package com.codingz2m.springaoprestservice.models;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
	
	public void checkOut(String status) {
		
		System.out.println("Checkout method is called from Shopping Cart: " + status);
		System.out.println(".......................................");
	}
	
	public void payment(double amount) {
		
		System.out.println("Payment method is called from Shopping Cart: " + amount);
		System.out.println(".......................................");
	}
}
