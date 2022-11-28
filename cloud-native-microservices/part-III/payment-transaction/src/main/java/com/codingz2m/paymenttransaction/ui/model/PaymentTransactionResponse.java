package com.codingz2m.paymenttransaction.ui.model;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class PaymentTransactionResponse {
	
	private Long id;
	private String transactionDate;
	private String transactionDetails;
	
	private double amount;
	private String debitOrCredit;
	private Long savingsAccountId;
	
	
	
}
