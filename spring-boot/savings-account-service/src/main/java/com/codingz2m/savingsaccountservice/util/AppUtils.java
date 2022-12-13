package com.codingz2m.savingsaccountservice.util;

import org.springframework.beans.BeanUtils;

import com.codingz2m.savingsaccountservice.collection.SavingsAccount;
import com.codingz2m.savingsaccountservice.dto.SavingsAccountDto;

public class AppUtils {
	
	public static SavingsAccountDto entityToDto(SavingsAccount savingsAccount) {
		SavingsAccountDto savingsAccountDto = new  SavingsAccountDto();
		BeanUtils.copyProperties(savingsAccount, savingsAccountDto);
		return savingsAccountDto;
	}
	
	public static SavingsAccount dtoToEntity(SavingsAccountDto savingsAccountDto) {
		SavingsAccount savingsAccount = new  SavingsAccount();
		BeanUtils.copyProperties(savingsAccountDto, savingsAccount);
		return savingsAccount;
	}
}
