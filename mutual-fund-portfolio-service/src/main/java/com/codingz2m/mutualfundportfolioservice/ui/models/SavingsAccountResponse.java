package com.codingz2m.mutualfundportfolioservice.ui.models;

import com.codingz2m.mutualfundportfolioservice.repository.MutualFundPortfolio;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SavingsAccountResponse {

	
	private Long id;
	private String holderName;
	private String accountType;
	private double annualPercentageYield;
	private double minimumBalanceToAvailAPY;
	private double minimumBalanceToOpenAccount;
	private double currentValue;
	private MutualFundPortfolio mutualFundPortfolio;
}
