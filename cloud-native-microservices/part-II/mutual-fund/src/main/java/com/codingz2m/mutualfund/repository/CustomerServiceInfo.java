package com.codingz2m.mutualfund.repository;

import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter @Setter @ToString
public class CustomerServiceInfo {
	
	 private String message;
	 private String mail;
	 private String contact;
	 
}
