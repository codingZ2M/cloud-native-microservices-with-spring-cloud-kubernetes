package com.codingz2m.mutualfund.ui.models;

import com.codingz2m.mutualfund.data.MutualFundPortfolio;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MutualFundResponse {
	
	private Long id;
	private String fundName;
	private String schemeType;
	private String fundType;
	
	private float nav;
	private double investedValue;
	private double currentValue;
	private long totalUnits;
	private long freeUnits;

	private long lockedUnits;
	private String investmentDate;
	private String investmentType;
	private String transactionDetails;
	
	private String debitOrCredit;
	private Long savingsAccountId;
	private MutualFundPortfolio mutualFundPortfolio;
	private String fundTransactionState;
	
	
	
}
