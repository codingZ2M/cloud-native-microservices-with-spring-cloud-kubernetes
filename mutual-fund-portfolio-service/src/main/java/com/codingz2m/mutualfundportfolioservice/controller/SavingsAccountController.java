package com.codingz2m.mutualfundportfolioservice.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingz2m.mutualfundportfolioservice.repository.MutualFundPortfolio;
import com.codingz2m.mutualfundportfolioservice.repository.SavingsAccount;
import com.codingz2m.mutualfundportfolioservice.service.SavingsAccountService;
import com.codingz2m.mutualfundportfolioservice.shared.SavingsAccountDTO;
import com.codingz2m.mutualfundportfolioservice.ui.models.MutualFundPortfolioResponse;
import com.codingz2m.mutualfundportfolioservice.ui.models.SavingsAccountRequest;
import com.codingz2m.mutualfundportfolioservice.ui.models.SavingsAccountResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/savings-account")
public class SavingsAccountController {
	
private static final Logger logger = LoggerFactory.getLogger(MutualFundController.class);
	
	private SavingsAccountService savingsAccountService;
	ModelMapper modelMapper;

	@Autowired
	public SavingsAccountController(@Qualifier("savingsAccountService")SavingsAccountService savingsAccountService, ModelMapper modelMapper) {
		super();
		this.savingsAccountService = savingsAccountService;
		this.modelMapper =  modelMapper;
	}
	
	// HTTP POST with SpringMVC
		@PostMapping	
			public ResponseEntity<SavingsAccountResponse> createSavingsAccount(@Valid @RequestBody SavingsAccountRequest savingsAccountRequest) {
			
			logger.info("createSavingsAccount() method in SavingsAccountController started");
			
				modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

				SavingsAccountDTO  savingsAccountDTO = modelMapper.map( savingsAccountRequest, SavingsAccountDTO.class); 
				
				SavingsAccount savingsAccount = savingsAccountService.createSavingsAccount(savingsAccountDTO);

				SavingsAccountResponse savingsAccountResponse = modelMapper.map(savingsAccount, SavingsAccountResponse.class);		    
				return ResponseEntity.status(HttpStatus.CREATED).body(savingsAccountResponse);
		   }
		
   
		// HTTP GET with Spring MVC
	    // One-To-Many Mapping (BI-Directional: From  SavingsAccount To MutualFundPortfolio Object)
		  @GetMapping(path ="/{savings-account-id}/mutual-fund-portfolio")
		    public ResponseEntity <MutualFundPortfolioResponse> getMutualFundPortfolioOfSavingsAccount(
		    		@PathVariable(value="savings-account-id") Long savingsAccountId){
			  
				modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
				
				MutualFundPortfolio mutualFundPortfolio = savingsAccountService.getMutualFundPortfolioOfSavingsAccount(savingsAccountId);
				  
				MutualFundPortfolioResponse mutualFundPortfolioResponse = modelMapper.map(mutualFundPortfolio, MutualFundPortfolioResponse.class);
				return ResponseEntity.status(HttpStatus.FOUND).body(mutualFundPortfolioResponse );
				
		    }
}
