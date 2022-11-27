package com.codingz2m.paymenttransaction.service;

import java.util.List;

import com.codingz2m.paymenttransaction.repository.PaymentTransaction;
import com.codingz2m.paymenttransaction.shared.PaymentTransactionDTO;

public interface PaymentTransactionService {
	
	PaymentTransaction paymentTransaction(PaymentTransactionDTO paymentTransactionDTO);
	
	List<PaymentTransaction> getPaymentTransactions(Long savimgsAccountId);
	
}