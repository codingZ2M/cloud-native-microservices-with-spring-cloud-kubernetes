package com.codingz2m.savingsaccount.services;

import java.util.List;

import com.codingz2m.savingsaccount.data.SavingsAccount;
import com.codingz2m.savingsaccount.shared.SavingsAccountDTO;
import com.codingz2m.savingsaccount.ui.models.PaymentTransactionRequest;

public interface SavingsAccountService {
	
	SavingsAccount createSavingsAccount(SavingsAccountDTO savingsAccountDTO);
	 
	List<SavingsAccount> getSavingsAccounts();
	
	SavingsAccount findAccountById(Long id);
	
	int savingsAccountTransaction(PaymentTransactionRequest savingsAccountTransactionRequest);
	
	boolean mutualFundTransaction(Long savingsAccountId, double mutualFundAmonunt);
	
	
}
