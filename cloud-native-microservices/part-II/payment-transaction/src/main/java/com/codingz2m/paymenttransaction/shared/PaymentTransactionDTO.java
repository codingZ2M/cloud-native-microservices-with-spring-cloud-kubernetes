package com.codingz2m.paymenttransaction.shared;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class PaymentTransactionDTO {
	
	private Long id;
	private String transactionDate;
	private String transactionDetails;
	
	private double amount;
	private String debitOrCredit;
	private Long savingsAccountId;
	
	
	
}
