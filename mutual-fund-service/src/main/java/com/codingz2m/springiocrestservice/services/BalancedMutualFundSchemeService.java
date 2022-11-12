package com.codingz2m.springiocrestservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.codingz2m.springiocrestservice.config.MutualFundSchemeConfig;
import com.codingz2m.springiocrestservice.models.MutualFundScheme;

// Annotation Based Configuration
@Service (value="balancedMFScheme")
@Primary
@Scope(scopeName="prototype")
public class BalancedMutualFundSchemeService implements MutualFundSchemeService {

	MutualFundScheme mutualFundScheme;
	MutualFundSchemeConfig mtualFundSchemeConfig;
	
	// Constructor Injection
	@Autowired
	public BalancedMutualFundSchemeService(MutualFundSchemeConfig mutualFundSchemeConfig) {
		this.mtualFundSchemeConfig = mutualFundSchemeConfig;
	}
	
	
	// Setter Injection
		@Autowired
		public void setMutualFundScheme(MutualFundScheme mutualFundScheme) {
			this.mutualFundScheme = mutualFundScheme;
		}


	@Override
	public MutualFundScheme mutualFundSchemeDetails() {
		
		List <String> schemeDescription  = mtualFundSchemeConfig.getList();
		
		schemeDescription.add(":: Balanced Mutual Fund Scheme Objectives ::");
		schemeDescription.add("Providing both growth and regular income");
		schemeDescription.add("Invested in equities and fixed income securities");
		
		mutualFundScheme.setSchemeDescription(schemeDescription);
		
		return mutualFundScheme;
	}


}
