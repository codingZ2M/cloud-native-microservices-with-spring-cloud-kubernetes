package com.codingz2m.springiocrestservice.config;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Java Based Configuration
@Configuration
public class MutualFundSchemeConfig {

	@Bean
	 public List<String> getList( ) {
		 List <String> schemeDescription  = new ArrayList<String>();
		 return schemeDescription;
	 }
	
 }
	


