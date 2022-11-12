package com.codingz2m.mutualfundservice.services;

import com.codingz2m.mutualfundservice.models.MutualFundParameters;
import com.codingz2m.mutualfundservice.models.MutualFundScheme;

public interface MutualFundSchemeService {
	
	MutualFundScheme mutualFundSchemeDetails();
	
	default MutualFundParameters mutualFundTerms() {
		
		return new MutualFundParameters();
	}

}
	
