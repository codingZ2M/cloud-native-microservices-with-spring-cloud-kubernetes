package com.codingz2m.mutualfund.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
//Loading all properties from the given file
//Once the particular property file loaded, reading all the properties with prefix value of "mutualfund"
@ConfigurationProperties(prefix = "mutualfund")
@Getter @Setter @ToString
public class MutualFundServiceConfig {
	
	 private String message;
	 private String mail;
	 private String contact;
	 
	 @Bean
	 public ModelMapper getModelMapper() {
		return new ModelMapper(); 
	 }
}
