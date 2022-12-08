package com.codingz2m.mutualfundservice.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MutualFundParameters {
	
	private String netAssetValue;
	private String expenseRatio; 
	private String exitLoad;
	private String assetsUnderManagement;
	private String riskLevel;
	private String portfolioTurnoverRatio;
	private String quantitativeMeasures;
	private String portfolio;

}
