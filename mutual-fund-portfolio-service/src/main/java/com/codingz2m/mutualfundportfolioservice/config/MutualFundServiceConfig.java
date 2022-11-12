package com.codingz2m.mutualfundportfolioservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MutualFundServiceConfig {
	 
	 @Bean
	 public ModelMapper getModelMapper() {
		return new ModelMapper(); 
	 }
	 
}
