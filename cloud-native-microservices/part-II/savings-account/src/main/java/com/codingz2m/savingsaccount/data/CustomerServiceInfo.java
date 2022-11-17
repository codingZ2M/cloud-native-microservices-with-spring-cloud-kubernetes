package com.codingz2m.savingsaccount.data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
  Configuration properties are isolated into separate POJOs.
 */

@Component
// Loading all properties from the given file
// Once the particular property file loaded, reading all the properties with prefix value of "savingsaccount"
@ConfigurationProperties(prefix="savingsaccount")
@Getter @Setter @ToString
public class CustomerServiceInfo {
	 private String message;
	 private String mail;
	 private String contact;

}
