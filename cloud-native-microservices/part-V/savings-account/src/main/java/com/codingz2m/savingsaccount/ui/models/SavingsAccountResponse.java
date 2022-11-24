package com.codingz2m.savingsaccount.ui.models;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
