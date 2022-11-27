package com.codingz2m.mutualfundportfolioservice.ui.models;

import com.codingz2m.mutualfundportfolioservice.repository.MutualFundPortfolio;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SavingsAccountRequest {
	@Null
	private Long id;
	@NotNull(message="Account Holder Name Cannot Be Null")
	private String holderName;
	@NotNull(message="Account Type Name Cannot Be Null")
	private String accountType;
	@NotNull(message="Annual Percentage Yield Cannot Be Null")
	private double annualPercentageYield;
	
	@NotNull(message="Minimum Balance To Avail APY Cannot Be Null")
	private double minimumBalanceToAvailAPY;
	
	@Min(value = 1000, message="Current Value must be greater than or equal to US $1000.00 ")
	@NotNull(message="Minimum Balance Cannot Be Null")
	private double minimumBalanceToOpenAccount;
	
	@Min(value = 1000, message="Current Value must be greater than or equal to US $1000.00 ")
	private double currentValue;
	
	private MutualFundPortfolio mutualFundPortfolio;
		
}
