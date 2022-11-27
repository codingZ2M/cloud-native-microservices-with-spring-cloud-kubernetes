package com.codingz2m.paymenttransaction.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingz2m.paymenttransaction.repository.PaymentTransaction;
import com.codingz2m.paymenttransaction.repository.PaymentTransactionRepository;
import com.codingz2m.paymenttransaction.shared.PaymentTransactionDTO;

import jakarta.transaction.Transactional;

@Service(value="paymentTransaction")
@Transactional
public class PaymentTransactionServiceImpl implements PaymentTransactionService {

	PaymentTransactionRepository  paymentTransactionRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	public PaymentTransactionServiceImpl(PaymentTransactionRepository paymentTransactionRepository) {
		super();
		this.paymentTransactionRepository = paymentTransactionRepository;
	}


	@Override
	public PaymentTransaction paymentTransaction(PaymentTransactionDTO paymentTransactionDTO) {
		 
		  modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		  
		  PaymentTransaction paymentTransaction = modelMapper.map(paymentTransactionDTO, PaymentTransaction.class);
		  paymentTransaction = paymentTransactionRepository.save(paymentTransaction);
	
		return paymentTransaction;
	}


	@Override
	public List<PaymentTransaction> getPaymentTransactions(Long savingsAccountId) {
		
		List <PaymentTransaction> paymentTransactionList = new ArrayList<>();
		paymentTransactionList = paymentTransactionRepository.getPaymentTransactions(savingsAccountId);
		return paymentTransactionList;
	}

}