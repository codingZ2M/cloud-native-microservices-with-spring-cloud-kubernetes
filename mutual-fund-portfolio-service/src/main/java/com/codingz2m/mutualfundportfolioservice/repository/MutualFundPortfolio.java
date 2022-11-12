package com.codingz2m.mutualfundportfolioservice.repository;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="mutual_fund_portfolio")
public class MutualFundPortfolio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable=false, length=50)
	private String holderName;
	@Column(nullable=false, length=20)
	private double totalInvestedValue;
	@Column(nullable=false, length=20)
	private double totalCurrentValue;
	@Column(nullable=false, length=6)
	private double gainOrLoss; 
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="mutualFundPortfolio", 
			cascade=CascadeType.ALL, orphanRemoval = true)
	private List<MutualFund> mutualFunds;

	// Mutual Fund Portfolio can't be created without savings account
	@OneToOne
	@JoinColumn(name="savings_account_id")
	private SavingsAccount savingsAccount;
	
	
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

	public double getTotalInvestedValue() {
		return totalInvestedValue;
	}

	public void setTotalInvestedValue(double totalInvestedValue) {
		this.totalInvestedValue = totalInvestedValue;
	}

	public double getTotalCurrentValue() {
		return totalCurrentValue;
	}

	public void setTotalCurrentValue(double totalCurrentValue) {
		this.totalCurrentValue = totalCurrentValue;
	}

	public double getGainOrLoss() {
		return gainOrLoss;
	}

	public void setGainOrLoss(double gainOrLoss) {
		this.gainOrLoss = gainOrLoss;
	}

	public List<MutualFund> retrieveMutualFunds() {
		return mutualFunds;
	}

	public void setMutualFunds(List<MutualFund> mutualFunds) {
		this.mutualFunds = mutualFunds;
	}

	public SavingsAccount getSavingsAccount() {
		return savingsAccount;
	}

	public void setSavingsAccount(SavingsAccount savingsAccount) {
		this.savingsAccount = savingsAccount;
	}
	 
	
}