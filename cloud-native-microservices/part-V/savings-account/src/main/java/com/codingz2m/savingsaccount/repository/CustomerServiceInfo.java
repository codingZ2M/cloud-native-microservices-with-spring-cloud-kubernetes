package com.codingz2m.savingsaccount.repository;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
  Configuration properties are isolated into separate POJOs.
 */

@Component
@Getter @Setter @ToString
public class CustomerServiceInfo {
	 private String message;
	 private String mail;
	 private String contact;

	 
}
