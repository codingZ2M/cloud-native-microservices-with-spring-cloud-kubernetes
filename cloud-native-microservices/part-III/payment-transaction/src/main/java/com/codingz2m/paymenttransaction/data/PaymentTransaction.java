package com.codingz2m.paymenttransaction.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="payment_transaction")
@Getter @Setter
public class PaymentTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable=false, length=60)
	private String transactionDate;
	
	@Column(nullable=false, length=200)
	private String transactionDetails;
	@Column(nullable=false, length=20)
	private double amount;
	
	@Column(nullable=false, length=10)
	private String debitOrCredit;
	@Column(nullable=false, length=50)
	private Long savingsAccountId;
	
	
	
}
