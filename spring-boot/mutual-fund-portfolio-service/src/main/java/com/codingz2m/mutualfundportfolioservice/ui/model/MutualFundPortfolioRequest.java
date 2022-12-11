package com.codingz2m.mutualfundportfolioservice.ui.model;

import org.springframework.stereotype.Component;

import com.codingz2m.mutualfundportfolioservice.repository.SavingsAccount;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

@Component
@Getter @Setter
public class MutualFundPortfolioRequest {
	
	@Null
	private Long id;
	@NotNull(message="Holder Name Cannot Be Null")
	private String holderName;
	
	@NotNull(message="Total Invested Value Cannot Be Null")
	@Min(value = 0, message="Total Invested Value must be greater than or equal to 0 ")
	private double totalInvestedValue;
	
	@NotNull(message="Total Current Value Cannot Be Null")
	@Min(value = 0, message="Total Current Value must be greater than or equal to 0 ")
	private double totalCurrentValue;

	@NotNull(message="Gain or Loss Cannot Be Null")
	private double gainOrLoss;
	
	@NotNull(message="Savings Account Id Cannot Be Null")
	private SavingsAccount savingsAccount;
}

