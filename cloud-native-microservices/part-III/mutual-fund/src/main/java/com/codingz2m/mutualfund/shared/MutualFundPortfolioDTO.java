package com.codingz2m.mutualfund.shared;

import java.util.List;
import com.codingz2m.mutualfund.repository.MutualFund;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MutualFundPortfolioDTO {

	private Long id;
	private String holderName;
	private double totalInvestedValue;
	
	private double totalCurrentValue;
	private double gainOrLoss; 
	private List<MutualFund> mutualFunds;
	
	
}
