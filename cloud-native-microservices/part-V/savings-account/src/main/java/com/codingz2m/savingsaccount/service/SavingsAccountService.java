package com.codingz2m.savingsaccount.service;

import java.util.List;

import com.codingz2m.savingsaccount.repository.SavingsAccount;
import com.codingz2m.savingsaccount.shared.SavingsAccountDTO;
import com.codingz2m.savingsaccount.ui.model.PaymentTransactionRequest;

public interface SavingsAccountService {
	
	SavingsAccount createSavingsAccount(SavingsAccountDTO savingsAccountDTO);
	 
	List<SavingsAccount> getSavingsAccounts();
	
	SavingsAccount findAccountById(Long id);
	
	int savingsAccountTransaction(PaymentTransactionRequest savingsAccountTransactionRequest);
	
	boolean mutualFundTransaction(Long savingsAccountId, double mutualFundAmonunt);
	
	
}
