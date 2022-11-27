package com.codingz2m.savingsaccount.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingz2m.savingsaccount.config.SavingsAccountServiceConfig;
import com.codingz2m.savingsaccount.repository.SavingsAccount;
import com.codingz2m.savingsaccount.service.SavingsAccountService;
import com.codingz2m.savingsaccount.shared.SavingsAccountDTO;
import com.codingz2m.savingsaccount.ui.model.PaymentTransactionRequest;
import com.codingz2m.savingsaccount.ui.model.PaymentTransactionResponse;
import com.codingz2m.savingsaccount.ui.model.SavingsAccountRequest;
import com.codingz2m.savingsaccount.ui.model.SavingsAccountResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/savings-account")
// Versioning with URL & Request Param
public class SavingsAccountController {

	private static final Logger logger = LoggerFactory.getLogger(SavingsAccountController.class);
	
	@Autowired
	private SavingsAccountServiceConfig savingsAccountServiceConfig;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private SavingsAccountService savingsAccountService;
	private PaymentTransactionProxy paymentTransactionProxy;
	
	@Autowired	
	public SavingsAccountController(@Qualifier("savingsAccount") SavingsAccountService savingsAccountService,
			PaymentTransactionProxy paymentTransactionProxy) {
	
		this.savingsAccountService = savingsAccountService;
		this.paymentTransactionProxy = paymentTransactionProxy;
	}
	
	
	// HTTP POST with SpringMVC
	@PostMapping("/v1")
	public ResponseEntity<SavingsAccountResponse> createSavingsAccount( @Valid @RequestBody SavingsAccountRequest savingsAccountRequest) {
		
	modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

	SavingsAccountDTO savingsAccountDTO = modelMapper.map( savingsAccountRequest, SavingsAccountDTO.class); 		
	SavingsAccount savingsAccount  = savingsAccountService.createSavingsAccount(savingsAccountDTO);

	SavingsAccountResponse savingsAccountResponse = modelMapper.map(savingsAccount, SavingsAccountResponse.class);
	
	return ResponseEntity.status(HttpStatus.CREATED).body(savingsAccountResponse);
  }
	
	
	
	@PostMapping(params= "version=2")
	public ResponseEntity<SavingsAccountResponse> createSavingsAccountV1( @Valid @RequestBody SavingsAccountRequest savingsAccountRequest) {
		
	modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

	SavingsAccountDTO savingsAccountDTO = modelMapper.map( savingsAccountRequest, SavingsAccountDTO.class); 		
	SavingsAccount savingsAccount  = savingsAccountService.createSavingsAccount(savingsAccountDTO);

	SavingsAccountResponse savingsAccountResponse = modelMapper.map(savingsAccount, SavingsAccountResponse.class);
	
	return ResponseEntity.status(HttpStatus.CREATED).body(savingsAccountResponse);
  }
	
	@GetMapping(path ="/all/v1")
	public List<SavingsAccountResponse> getAllSavingsAccount() {
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		List <SavingsAccount> savingsAccountList   = new ArrayList<>();
		savingsAccountList = savingsAccountService.getSavingsAccounts();
		
		List <SavingsAccountResponse> savingsAccountResponseList =  new ArrayList<>();
		savingsAccountResponseList = Arrays.asList(modelMapper.map(savingsAccountList, SavingsAccountResponse[].class));
		return savingsAccountResponseList;
	}
	
	
	
	// 	Implementing HATEOAS for REST API - Creating HAL Compatible REST API
	@PostMapping("/getSavingsAccount/v1")
	public EntityModel<SavingsAccountResponse> findSavingsAccount(@RequestBody SavingsAccountRequest savingsAccountRequest) {
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		SavingsAccount savingsAccount = savingsAccountService.findAccountById(savingsAccountRequest.getId());
		
		if (savingsAccount != null) {
			SavingsAccountResponse savingsAccountResponse = modelMapper.map(savingsAccount, SavingsAccountResponse.class);
	
			EntityModel<SavingsAccountResponse> entityModel = EntityModel.of(savingsAccountResponse);
				
			WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllSavingsAccount());
				entityModel.add(link.withRel("all-savings-accounts"));
			return entityModel;
		} else {
			return null;
		}
	}
	
	
	
	
	// HTTP POST with SpringMVC
	@PostMapping( path="/payment-transaction")
	public void initiateSavingsAccountTransaction( @Valid @RequestBody PaymentTransactionRequest paymentTransactionRequest) {		 		
		
		int transactionCount = savingsAccountService.savingsAccountTransaction(paymentTransactionRequest);
        
		if(transactionCount == 1) {			
			paymentTransactionProxy.initiatePaymentTransaction(paymentTransactionRequest);
		} 
	  }
	
	
	
	
	@GetMapping(path ="/{savings-account-id}/payment-transactions")
	public List<PaymentTransactionResponse> getPaymentTransactions(
    		@PathVariable(value="savings-account-id") Long savingsAccountId) {
		
		List <PaymentTransactionResponse> paymentTransactionResponseList   = new ArrayList<>();
		paymentTransactionResponseList = paymentTransactionProxy.getPaymentTransactions(savingsAccountId);
		  return paymentTransactionResponseList;
	}
	
	

	@PostMapping(path ="/{savings-account-id}/{mutual-fund-amonunt}/mutual-fund")
	public boolean initiateMutualFundTransaction(
			@PathVariable(value="savings-account-id") Long savingsAccountId, 
			@PathVariable(value="mutual-fund-amonunt") double mutualFundAmonunt  ) {
		
		logger.info("initiateMutualFundTransaction() method in savings-account service started");
		
	  boolean fundTransactionState;
	  fundTransactionState = savingsAccountService.mutualFundTransaction(savingsAccountId, mutualFundAmonunt);
	  logger.info("initiateMutualFundTransaction() method in savings-account service ended");
	  return fundTransactionState;
	}

	
}
