package com.codingz2m.springiocrestservice.services;

import com.codingz2m.springiocrestservice.models.MutualFundParameters;
import com.codingz2m.springiocrestservice.models.MutualFundScheme;

public interface MutualFundSchemeService {
	
	MutualFundScheme mutualFundSchemeDetails();
	
	default MutualFundParameters mutualFundTerms() {
		
		return new MutualFundParameters();
	}

}
	
