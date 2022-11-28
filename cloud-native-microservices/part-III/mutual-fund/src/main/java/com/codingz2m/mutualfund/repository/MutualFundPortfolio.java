package com.codingz2m.mutualfund.repository;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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
	 
}