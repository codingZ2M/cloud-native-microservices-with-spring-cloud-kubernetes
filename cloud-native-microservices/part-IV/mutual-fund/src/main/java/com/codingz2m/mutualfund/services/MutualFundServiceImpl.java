package com.codingz2m.mutualfund.services;

import java.util.List;

import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingz2m.mutualfund.data.MutualFund;
import com.codingz2m.mutualfund.data.MutualFundPortfolio;
import com.codingz2m.mutualfund.data.MutualFundPortfolioRepository;
import com.codingz2m.mutualfund.data.MutualFundRepository;
import com.codingz2m.mutualfund.shared.MutualFundDTO;
import com.codingz2m.mutualfund.shared.MutualFundPortfolioDTO;


@Service(value="mutualFundService")
@Transactional 
public class MutualFundServiceImpl implements MutualFundService {

	MutualFundRepository  mutualFundRepository;
	MutualFundPortfolioRepository mutualFundPortfolioRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	public MutualFundServiceImpl(MutualFundRepository mutualFundRepository,
			MutualFundPortfolioRepository mutualFundPortfolioRepository
			) {
		super();
		this.mutualFundRepository = mutualFundRepository;
		this.mutualFundPortfolioRepository = mutualFundPortfolioRepository;
	  }

	
	@Override
	public MutualFund createMutualFund(MutualFundDTO mutualFundDTO) {
		
		 Long mutualFundPortfolioId = mutualFundDTO.getMutualFundPortfolio().getId();
		 double totalInvestedValue = mutualFundPortfolioRepository.getPortfolioTotalInvestedValue(mutualFundPortfolioId);
			double investedValue =  mutualFundDTO.getInvestedValue();
			totalInvestedValue += investedValue;
			 
			  modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			  
			  MutualFund mutualFund = modelMapper.map(mutualFundDTO, MutualFund.class);
			  mutualFund = mutualFundRepository.save(mutualFund);
			  mutualFundPortfolioRepository.updateMutualFundPortfolio(mutualFundPortfolioId, totalInvestedValue);
			  
			return mutualFund;
	}

	
	@Override
	public MutualFundPortfolio createMutualFundPortfolio(MutualFundPortfolioDTO mutualFundPortfolioDTO) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<MutualFund> getMutualFundsOfPortfolio(Long mutualFundPortfolioId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
