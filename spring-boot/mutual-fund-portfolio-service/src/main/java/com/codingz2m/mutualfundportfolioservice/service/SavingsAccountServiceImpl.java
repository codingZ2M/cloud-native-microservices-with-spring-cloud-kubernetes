package com.codingz2m.mutualfundportfolioservice.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingz2m.mutualfundportfolioservice.repository.MutualFundPortfolio;
import com.codingz2m.mutualfundportfolioservice.repository.SavingsAccount;
import com.codingz2m.mutualfundportfolioservice.repository.SavingsAccountRepository;
import com.codingz2m.mutualfundportfolioservice.shared.SavingsAccountDTO;

import jakarta.transaction.Transactional;

@Service (value="savingsAccountService")
@Transactional 
public class SavingsAccountServiceImpl implements SavingsAccountService {

	
	private SavingsAccountRepository savingsAccountRepository;
	
	
	ModelMapper	modelMapper;
	
	@Autowired
	public SavingsAccountServiceImpl(SavingsAccountRepository savingsAccountRepository, ModelMapper modelMapper) {
		super();
		this.savingsAccountRepository = savingsAccountRepository;
		this.modelMapper =modelMapper;
	}


	@Override
	public SavingsAccount createSavingsAccount(SavingsAccountDTO savingsAccountDTO) {

		   modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		   SavingsAccount savingsAccount = modelMapper.map(savingsAccountDTO, SavingsAccount.class);
		   
		   savingsAccount =   savingsAccountRepository.save(savingsAccount);
		return savingsAccount;
	}


	@Override
	public MutualFundPortfolio getMutualFundPortfolioOfSavingsAccount(Long savingsAccountId) {
		
		Optional <SavingsAccount> savingsAccountOptional = savingsAccountRepository.findById(savingsAccountId);
		SavingsAccount savingsAccountObject = savingsAccountOptional.get();
		
		MutualFundPortfolio mutualFundPortfolio =	savingsAccountObject.retrieveMutualFundPortfolio();
		return mutualFundPortfolio;
	}

}
