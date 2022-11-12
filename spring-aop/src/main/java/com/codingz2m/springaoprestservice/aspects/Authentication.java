package com.codingz2m.springaoprestservice.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Authentication {
	
	/*
	 Pointcut: A pointcut defines at what joinpoints, the associated 
	 Advice should be applied. 
	 */

	
	//@Pointcut("within(com.codingz2m.springaoprestservice.models.ShoppingCart)")
	//@Pointcut("execution(* com.codingz2m.springaoprestservice.models.ShoppingCart.checkOut*(..))")
	@Pointcut("execution(* com.codingz2m.springaoprestservice.models.*.*(..))")
	public void authenticatingPointcut() {
		System.out.println("Authenticating... ");
	}	
		
		
	@Pointcut("within(com.codingz2m.springaoprestservice.models.Payment)")
	public void authorizationPointcut() { 
		System.out.println("Authorization... "); 
	}	
	
	 //@Before("authenticatingPointcut() && authorizationPointcut()")
	  @Before("authenticatingPointcut()")
		public void authenticate() {
			System.out.println("Authenticating the request..");
		}
	  
		@After("authorizationPointcut()")
		public void autherize() {
			System.out.println("Authorizing the request.. after executing 'transaction()' from Payment");
		}
		@AfterReturning("authorizationPointcut()")
		public void confirmPurchase( ) {
			System.out.println("Confirming Purchase Order.. after executing 'transaction()' from Payment");
		}
	
		
	
}

