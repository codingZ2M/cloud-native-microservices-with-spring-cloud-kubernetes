	package com.codingz2m.mutualfund.shared;

import java.util.List;
import com.codingz2m.mutualfund.data.MutualFund;

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
