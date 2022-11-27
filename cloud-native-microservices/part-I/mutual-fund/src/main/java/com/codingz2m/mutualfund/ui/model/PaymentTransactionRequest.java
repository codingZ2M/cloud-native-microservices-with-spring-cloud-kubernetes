package com.codingz2m.mutualfund.ui.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PaymentTransactionRequest {
	
	private String transactionDate;
	private String transactionDetails;
	
	private double amount;
	private String debitOrCredit;
	private Long savingsAccountId;
 
	 
}
