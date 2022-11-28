package com.codingz2m.savingsaccount.ui.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
//@JsonIgnoreProperties("minimumBalanceToOpenAccount")
//@JsonFilter("SavingsAccountResponseFilter")
public class SavingsAccountResponse {

	private Long id;
	private String holderName;
	private String accountType;

	private double annualPercentageYield; 
	private double minimumBalanceToAvailAPY;
	//@JsonIgnore
	private double minimumBalanceToOpenAccount;
	private double currentValue;
	}
