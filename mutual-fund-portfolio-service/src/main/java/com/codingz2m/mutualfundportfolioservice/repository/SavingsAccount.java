package com.codingz2m.mutualfundportfolioservice.repository;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="savings_account")

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
	
	@OneToOne(fetch=FetchType.EAGER, mappedBy="savingsAccount", 
	cascade=CascadeType.ALL)
	private MutualFundPortfolio mutualFundPortfolio;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAnnualPercentageYield() {
		return annualPercentageYield;
	}

	public void setAnnualPercentageYield(double annualPercentageYield) {
		this.annualPercentageYield = annualPercentageYield;
	}

	public double getMinimumBalanceToAvailAPY() {
		return minimumBalanceToAvailAPY;
	}

	public void setMinimumBalanceToAvailAPY(double minimumBalanceToAvailAPY) {
		this.minimumBalanceToAvailAPY = minimumBalanceToAvailAPY;
	}

	public double getMinimumBalanceToOpenAccount() {
		return minimumBalanceToOpenAccount;
	}

	public void setMinimumBalanceToOpenAccount(double minimumBalanceToOpenAccount) {
		this.minimumBalanceToOpenAccount = minimumBalanceToOpenAccount;
	}

	public double getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}

	public MutualFundPortfolio retrieveMutualFundPortfolio() {
		return mutualFundPortfolio;
	}

	public void setMutualFundPortfolio(MutualFundPortfolio mutualFundPortfolio) {
		this.mutualFundPortfolio = mutualFundPortfolio;
	}
	
	
}
