package com.codingz2m.springiocrestservice.models;

import org.springframework.stereotype.Component;

@Component
public class MutualFundParameters {
	
	private String netAssetValue;
	private String expenseRatio; 
	private String exitLoad;
	private String assetsUnderManagement;
	private String riskLevel;
	private String portfolioTurnoverRatio;
	private String quantitativeMeasures;
	private String portfolio;
	
	public String getNetAssetValue() {
		return netAssetValue;
	}

	public void setNetAssetValue(String netAssetValue) {
		this.netAssetValue = netAssetValue;
	}

	public String getExpenseRatio() {
		return expenseRatio;
	}

	public void setExpenseRatio(String expenseRatio) {
		this.expenseRatio = expenseRatio;
	}

	public String getExitLoad() {
		return exitLoad;
	}

	public void setExitLoad(String exitLoad) {
		this.exitLoad = exitLoad;
	}

	public String getAssetsUnderManagement() {
		return assetsUnderManagement;
	}

	public void setAssetsUnderManagement(String assetsUnderManagement) {
		this.assetsUnderManagement = assetsUnderManagement;
	}

	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public String getPortfolioTurnoverRatio() {
		return portfolioTurnoverRatio;
	}

	public void setPortfolioTurnoverRatio(String portfolioTurnoverRatio) {
		this.portfolioTurnoverRatio = portfolioTurnoverRatio;
	}

	public String getQuantitativeMeasures() {
		return quantitativeMeasures;
	}

	public void setQuantitativeMeasures(String quantitativeMeasures) {
		quantitativeMeasures = quantitativeMeasures;
	}

	public String getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}
	
	

	
}
