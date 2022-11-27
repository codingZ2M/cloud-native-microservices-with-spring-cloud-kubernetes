package com.codingz2m.mutualfundportfolioservice.controller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingz2m.mutualfundportfolioservice.repository.MutualFund;
import com.codingz2m.mutualfundportfolioservice.service.MutualFundService;
import com.codingz2m.mutualfundportfolioservice.shared.MutualFundDTO;
import com.codingz2m.mutualfundportfolioservice.ui.models.MutualFundRequest;
import com.codingz2m.mutualfundportfolioservice.ui.models.MutualFundResponse;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/mutual-fund")
public class MutualFundController {
	
	private static final Logger logger = LoggerFactory.getLogger(MutualFundController.class);
	
	@Autowired
	ModelMapper modelMapper;
	
	private MutualFundService mutualFundService;
	
	@Autowired	
	public MutualFundController(@Qualifier("mutualFundService") MutualFundService mutualFundService) {
		super();
		this.mutualFundService = mutualFundService;
	}
	
	// HTTP POST with SpringMVC
	@PostMapping
	public ResponseEntity<MutualFundResponse> createMutualFund( 
			@Valid @RequestBody MutualFundRequest mutualFundRequest ) {
		
		logger.info("createMutualFund() method in mutual-fund-controller started");
		MutualFund mutualFund=null;
		MutualFundResponse mutualFundResponse = null;
		MutualFundDTO mutualFundDTO = null;
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		mutualFundDTO = modelMapper.map( mutualFundRequest, MutualFundDTO.class); 
		
			mutualFund  = mutualFundService.createMutualFund(mutualFundDTO);
			mutualFundResponse = modelMapper.map(mutualFund, MutualFundResponse.class);
				
		 return ResponseEntity.status(HttpStatus.CREATED).body(mutualFundResponse);
  }
	
	
	@DeleteMapping(path ="/{mutualFundId}")
	public int deleteMutualFundById(@PathVariable(value="mutualFundId") Long id) {
		int count = mutualFundService.deleteMutualFundById(id);
		return count;
	}
	
}

