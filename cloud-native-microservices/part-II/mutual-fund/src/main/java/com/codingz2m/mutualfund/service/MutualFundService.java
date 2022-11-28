package com.codingz2m.mutualfund.service;

import java.util.List;

import com.codingz2m.mutualfund.repository.MutualFund;
import com.codingz2m.mutualfund.repository.MutualFundPortfolio;
import com.codingz2m.mutualfund.shared.MutualFundDTO;
import com.codingz2m.mutualfund.shared.MutualFundPortfolioDTO;

public interface MutualFundService {
	
	MutualFundPortfolio createMutualFundPortfolio(MutualFundPortfolioDTO mutualFundPortfolioDTO);
	
	MutualFund createMutualFund(MutualFundDTO mutualFundDTO);
	
	List<MutualFund> getMutualFundsOfPortfolio(Long mutualFundPortfolioId);
}
