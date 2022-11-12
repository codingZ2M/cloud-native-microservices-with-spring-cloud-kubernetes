package com.codingz2m.springaoprestservice.models;

import org.springframework.stereotype.Component;

@Component
public class Payment {
	
	public void transaction(double amount) {
		
		System.out.println("Transaction method is called from Payment: " + amount);
		System.out.println(".......................................");
	}
	
	
}
