package com.codingz2m.mutualfund.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Configuration
@Getter @Setter @ToString
public class MutualFundServiceConfig {

	 @Bean
	 public ModelMapper getModelMapper() {
		return new ModelMapper(); 
	 }
}
