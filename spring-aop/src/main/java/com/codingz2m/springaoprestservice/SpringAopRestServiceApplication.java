package com.codingz2m.springaoprestservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.codingz2m.springaoprestservice.config.BeansConfig;
import com.codingz2m.springaoprestservice.models.Payment;
import com.codingz2m.springaoprestservice.models.ShoppingCart;

@SpringBootApplication
public class SpringAopRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAopRestServiceApplication.class, args);
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(BeansConfig.class);
		
		ShoppingCart cart = context.getBean(ShoppingCart.class);
		cart.checkOut("PROCESSED");
		cart.payment(1000.00);
		
		Payment payment = context.getBean(Payment.class);
		payment.transaction(200.00);
	}

}
