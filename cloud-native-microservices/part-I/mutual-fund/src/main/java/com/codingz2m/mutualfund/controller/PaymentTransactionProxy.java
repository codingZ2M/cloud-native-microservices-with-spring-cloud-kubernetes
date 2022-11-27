package com.codingz2m.mutualfund.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import com.codingz2m.mutualfund.ui.model.PaymentTransactionRequest;


// ****** MAKING REST CALLS USING FEIGN CLIENT **********

//@FeignClient("PAYMENT-TRANSACTION")
@FeignClient(name = "payment-transaction", url = "${PAYMENT_TRANSACTION_SERVICE_HOST:http://localhost}:8082")
public interface PaymentTransactionProxy {

	@PostMapping("/payment-transaction")
	public void initiatePaymentTransaction(PaymentTransactionRequest paymentTransactionRequest);
}