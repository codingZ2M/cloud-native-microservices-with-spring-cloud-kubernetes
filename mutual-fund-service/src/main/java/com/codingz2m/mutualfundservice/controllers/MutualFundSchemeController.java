package com.codingz2m.mutualfundservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingz2m.mutualfundservice.models.MutualFundParameters;
import com.codingz2m.mutualfundservice.models.MutualFundScheme;
import com.codingz2m.mutualfundservice.services.MutualFundSchemeService;



//Annotation Based Configuration
@RestController // Routes the requests the user types
@RequestMapping(value = "/mutualfund-scheme")
public class MutualFundSchemeController {
	
	MutualFundSchemeService mutualFundSchemeService;
	MutualFundSchemeService mutualFundBasics;
	

	// Constructor Injection
	@Autowired
	public MutualFundSchemeController(@Qualifier ("equityMFScheme") MutualFundSchemeService mutualFundSchemeService,
			@Qualifier("mutualFundBasics")  MutualFundSchemeService mutualFundBasics) {
		super();
		this.mutualFundSchemeService = mutualFundSchemeService;
		this.mutualFundBasics = mutualFundBasics;
	}



	@GetMapping
	public ResponseEntity<MutualFundScheme>  mutualFundDetailsHandler(){
			  
		MutualFundScheme mutualFundScheme = mutualFundSchemeService.mutualFundSchemeDetails();
	 //HTTP status return code for a successful find statement        
	   return new ResponseEntity<MutualFundScheme>(mutualFundScheme, HttpStatus.FOUND); 
	
	 }

	@GetMapping(value="/terms")
	public ResponseEntity<MutualFundParameters>  mutualFundTerms(){
		MutualFundParameters mutualFundParameters = mutualFundBasics.mutualFundTerms();
		
		return new ResponseEntity<MutualFundParameters>(mutualFundParameters, HttpStatus.FOUND); 
	
	 }


	
	
}
