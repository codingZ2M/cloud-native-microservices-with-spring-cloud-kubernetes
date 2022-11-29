package com.codingz2m.mutualfund.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingz2m.mutualfund.repository.MutualFund;
import com.codingz2m.mutualfund.repository.MutualFundPortfolio;
import com.codingz2m.mutualfund.repository.MutualFundPortfolioRepository;
import com.codingz2m.mutualfund.shared.MutualFundDTO;
import com.codingz2m.mutualfund.shared.MutualFundPortfolioDTO;

import jakarta.transaction.Transactional;

import java.util.Optional;

@Service (value="mutualFundPortfolio")
@Transactional 
public class MutualFundPortfolioServiceImpl implements MutualFundService {
	
	MutualFundPortfolioRepository  mutualFundPortfolioRepository;
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	public MutualFundPortfolioServiceImpl(MutualFundPortfolioRepository mutualFundPortfolioRepository) {
		super();
		this.mutualFundPortfolioRepository = mutualFundPortfolioRepository;
	}

	@Override
	public MutualFundPortfolio createMutualFundPortfolio(MutualFundPortfolioDTO mutualFundPortfolioDTO) {
		 
		   modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		  
		   MutualFundPortfolio mutualFundPortfolio = modelMapper.map(mutualFundPortfolioDTO, MutualFundPortfolio.class);
		   mutualFundPortfolio =   mutualFundPortfolioRepository.save(mutualFundPortfolio);
		       
		return mutualFundPortfolio;
	}

	@Override
	public List<MutualFund> getMutualFundsOfPortfolio(Long mutualFundPortfolioId) {
	List <MutualFund> mutualFundList = new ArrayList<>();
		
		Optional<MutualFundPortfolio> mutualFundPortfolioOptional = mutualFundPortfolioRepository.findById(mutualFundPortfolioId);
		MutualFundPortfolio mutualFundPortfolioObject = mutualFundPortfolioOptional.get();
			mutualFundList =	mutualFundPortfolioObject.retrieveMutualFunds();
		return mutualFundList;
	}
	
	
	@Override
	public MutualFund createMutualFund(MutualFundDTO mutualFundDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	

	


}
