package com.codingz2m.mutualfundservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.codingz2m.mutualfundservice.config.MutualFundSchemeConfig;
import com.codingz2m.mutualfundservice.models.MutualFundScheme;

//Annotation Based Configuration
@Service (value="equityMFScheme")
public class EquityMutualFundSchemeService implements MutualFundSchemeService {

	MutualFundScheme mutualFundScheme;
	MutualFundSchemeConfig mtualFundSchemeConfig;
	
	// Constructor Injection
	@Autowired
	public EquityMutualFundSchemeService(MutualFundSchemeConfig mtualFundSchemeConfig) {
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
		
		schemeDescription.add(":: Growth / Equity Mutual Fund Scheme Objectives ::");
		schemeDescription.add("Objective is wealth creation");
		schemeDescription.add("Generating higher returns for long term investments");
		schemeDescription.add("Capital appreciation over a period of time");
		
		mutualFundScheme.setSchemeDescription(schemeDescription);
		
		return mutualFundScheme;
	}

}
