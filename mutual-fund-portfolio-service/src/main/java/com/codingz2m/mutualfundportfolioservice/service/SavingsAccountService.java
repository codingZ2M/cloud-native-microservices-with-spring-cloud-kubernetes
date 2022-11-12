package com.codingz2m.mutualfundportfolioservice.service;

import com.codingz2m.mutualfundportfolioservice.repository.MutualFundPortfolio;
import com.codingz2m.mutualfundportfolioservice.repository.SavingsAccount;
import com.codingz2m.mutualfundportfolioservice.shared.SavingsAccountDTO;

public interface SavingsAccountService {

	SavingsAccount createSavingsAccount(SavingsAccountDTO savingsAccountDTO);
	
	MutualFundPortfolio getMutualFundPortfolioOfSavingsAccount(Long savingsAccountId);
}
