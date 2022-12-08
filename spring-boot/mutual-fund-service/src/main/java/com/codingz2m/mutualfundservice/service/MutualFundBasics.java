package com.codingz2m.mutualfundservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codingz2m.mutualfundservice.model.MutualFundParameters;
import com.codingz2m.mutualfundservice.model.MutualFundScheme;

@Service (value="mutualFundBasics")
public class MutualFundBasics implements MutualFundSchemeService {

	private MutualFundParameters mutualFundParameters;
	
	@Autowired
	public MutualFundBasics(MutualFundParameters mutualFundParameters) {
		super();
		this.mutualFundParameters = mutualFundParameters;
	}

	@Override
	public MutualFundScheme mutualFundSchemeDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	public MutualFundParameters mutualFundTerms() {
		
		mutualFundParameters.setNetAssetValue("Market value per unit of mutual funds");
		mutualFundParameters.setExpenseRatio("Operational charges as mutual funds");
		mutualFundParameters.setExitLoad("Premature exit from the fund");
		mutualFundParameters.setAssetsUnderManagement("Total assets that are being managed by a mutual fund scheme");
		mutualFundParameters.setRiskLevel("How much risk the particular scheme entail");
		mutualFundParameters.setPortfolioTurnoverRatio("Defines how frequently the mutual fund manger buys or sells the stocks from the fund");
		mutualFundParameters.setQuantitativeMeasures("Gives an idea of the risk taken by the mutual fund and the volatility you can expect in your returns");
		mutualFundParameters.setPortfolio("The stocks the mutual fund has invested in and the sectors( percentage of Total Holdings)it has more exposure to");
		
		return mutualFundParameters;
	}
}
