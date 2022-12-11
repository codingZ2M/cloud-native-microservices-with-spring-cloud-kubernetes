package com.codingz2m.mutualfundportfolioservice.ui.model;

import java.util.List;
import com.codingz2m.mutualfundportfolioservice.repository.MutualFund;
import com.codingz2m.mutualfundportfolioservice.repository.SavingsAccount;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MutualFundPortfolioResponse {

	private Long id;
	private String holderName;
	private double totalInvestedValue;
	
	private double totalCurrentValue;
	private double gainOrLoss; 
	private List<MutualFund> mutualFunds;
	
	private SavingsAccount savingsAccount;
	
}
