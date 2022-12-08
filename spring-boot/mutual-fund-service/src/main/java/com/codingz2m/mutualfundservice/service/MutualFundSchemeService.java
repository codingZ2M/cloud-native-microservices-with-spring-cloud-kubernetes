package com.codingz2m.mutualfundservice.service;

import com.codingz2m.mutualfundservice.model.MutualFundParameters;
import com.codingz2m.mutualfundservice.model.MutualFundScheme;

public interface MutualFundSchemeService {
	
	MutualFundScheme mutualFundSchemeDetails();
	
	default MutualFundParameters mutualFundTerms() {
		
		return new MutualFundParameters();
	}

}
	
