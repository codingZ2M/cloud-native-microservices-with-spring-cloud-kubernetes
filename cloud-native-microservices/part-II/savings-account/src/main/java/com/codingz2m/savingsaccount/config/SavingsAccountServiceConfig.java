package com.codingz2m.savingsaccount.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Configuration
//Loading all properties from the given file
//Once the particular property file loaded, reading all the properties with prefix value of "savingsaccount"
@ConfigurationProperties(prefix = "savingsaccount")
@Getter @Setter @ToString
public class SavingsAccountServiceConfig {
	
	 private String message;
	 private String mail;
	 private String contact;
	 
	 @Bean
	 public ModelMapper getModelMapper() {
		return new ModelMapper(); 
	 }
}
