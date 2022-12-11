package com.codingz2m.mutualfundportfolioservice.service;

import java.util.List;
import com.codingz2m.mutualfundportfolioservice.repository.MutualFund;
import com.codingz2m.mutualfundportfolioservice.repository.MutualFundPortfolio;
import com.codingz2m.mutualfundportfolioservice.shared.MutualFundDTO;
import com.codingz2m.mutualfundportfolioservice.shared.MutualFundPortfolioDTO;

public interface MutualFundService {
	
	MutualFundPortfolio createMutualFundPortfolio(MutualFundPortfolioDTO mutualFundPortfolioDTO);
	
	MutualFund createMutualFund(MutualFundDTO mutualFundDTO);
	
	List<MutualFund> getMutualFundsOfPortfolio(Long mutualFundPortfolioId);
	
	int deleteMutualFundById(Long id);
}	
