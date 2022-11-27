package com.codingz2m.savingsaccount.repository;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="savings_account")
@Getter @Setter
public class SavingsAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable=false, length=120)
	private String holderName;
	
	@Column(nullable=false, length=120)
	private String accountType;
	@Column(nullable=false, length=5)
	private double annualPercentageYield;
	@Column(nullable=false, length=10)
	private double minimumBalanceToAvailAPY;
	
	@Column(nullable=false, length=10)
	private double minimumBalanceToOpenAccount;
	@Column(nullable=false, length=20)
	private double currentValue;
	
	
	
}
