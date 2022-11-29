package com.codingz2m.savingsaccount.shared;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SavingsAccountDTO {

	private Long id;
	private String holderName;
	private String accountType;
	
	private double annualPercentageYield; 
	private double minimumBalanceToAvailAPY;
	private double minimumBalanceToOpenAccount;
	private double currentValue;
	
	
}
