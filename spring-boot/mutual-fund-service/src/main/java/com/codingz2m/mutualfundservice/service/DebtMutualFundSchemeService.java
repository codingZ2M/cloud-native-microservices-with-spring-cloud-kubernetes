package com.codingz2m.mutualfundservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingz2m.mutualfundservice.config.MutualFundSchemeConfig;
import com.codingz2m.mutualfundservice.model.MutualFundScheme;

//Annotation Based Configuration
@Service (value="debtMFScheme")
public class DebtMutualFundSchemeService implements MutualFundSchemeService {

	MutualFundScheme mutualFundScheme;
	MutualFundSchemeConfig mtualFundSchemeConfig;
	
	// Constructor Injection
	@Autowired
	public DebtMutualFundSchemeService(MutualFundSchemeConfig mtualFundSchemeConfig) {
		this.mtualFundSchemeConfig = mtualFundSchemeConfig;
	}
	
	// Setter Injection
		@Autowired
		public void setMutualFundScheme(MutualFundScheme mutualFundScheme) {
			this.mutualFundScheme = mutualFundScheme;
		}


	@Override
	public MutualFundScheme mutualFundSchemeDetails() {
		
		List <String> schemeDescription  = mtualFundSchemeConfig.getList();
		schemeDescription.add(":: Debt Mutual Fund Scheme Objectives ::");
		schemeDescription.add("Providing regular and steady income to investors");
		schemeDescription.add("Invested in bonds, corporate debentures, money market instruments");
		schemeDescription.add("Less risky compared to equity schemes");
		
		mutualFundScheme.setSchemeDescription(schemeDescription);
		
		return mutualFundScheme;
	}

	
}
