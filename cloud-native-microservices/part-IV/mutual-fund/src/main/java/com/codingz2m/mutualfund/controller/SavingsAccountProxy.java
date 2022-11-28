package com.codingz2m.mutualfund.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


// ****** MAKING REST CALLS USING FEIGN CLIENT **********

//@FeignClient("SAVINGSACCOUNT")
@FeignClient(name = "savings-account", url = "${SAVINGS_ACCOUNT_SERVICE_HOST:http://localhost}:8081")
public interface SavingsAccountProxy {

	@PostMapping("/savings-account/{savings-account-id}/{mutual-fund-amonunt}/mutual-fund")
	public boolean initiateMutualFundTransaction(
			@PathVariable(value="savings-account-id")Long savingsAccountId, 
			@PathVariable(value="mutual-fund-amonunt") double mutualFundAmonunt);
}