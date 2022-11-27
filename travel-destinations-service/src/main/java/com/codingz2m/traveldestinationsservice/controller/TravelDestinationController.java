package com.codingz2m.traveldestinationsservice.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingz2m.traveldestinationsservice.entity.TravelDestination;
import com.codingz2m.traveldestinationsservice.exception.TravelDestinationNotFoundException;
import com.codingz2m.traveldestinationsservice.service.TravelDestinationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/traveldestinations")  // Exposing a REST API End Point 
public class TravelDestinationController {
	
	private final Logger logger = LoggerFactory.getLogger(TravelDestinationController.class );
	private TravelDestinationService travelDestinationService;
    
	@Value("${welcome.message}")
	private String welcomeMessage;
	@Value("${spring.application.name}")
	private String appName;

	
	@Autowired
	public TravelDestinationController(@Qualifier("tds")TravelDestinationService travelDestinationService) {
		this.travelDestinationService = travelDestinationService;
	}
	
	@PostMapping
	public ResponseEntity<TravelDestination> addTravelDestination(@Valid @RequestBody TravelDestination travelDestination) {
		
		logger.info("Inside addTravelDestination() of TravelDestinationController");
		travelDestination = travelDestinationService.addTravelDestination(travelDestination);
		return ResponseEntity.status(HttpStatus.CREATED).body(travelDestination);
	  }

	@GetMapping("/message")
	public ResponseEntity <String> message(){
		String message = welcomeMessage + " | " + appName;
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}
	   
	@GetMapping 
	public ResponseEntity <List<TravelDestination>> getAllTravelDestinations(){
		
		logger.info("Inside getAllTravelDestinations() of TravelDestinationController");
		List <TravelDestination> allTravelDestinations = travelDestinationService.findAllTravelDestinations();
		return ResponseEntity.status(HttpStatus.FOUND).body(allTravelDestinations);
	}

	@GetMapping (path ="/{country}")
	public ResponseEntity <List<TravelDestination>> getTravelDestinationsByCountry (
			@PathVariable(value="country") String country) throws TravelDestinationNotFoundException {
		
		logger.info("Inside getTravelDestinationsByCountry () of TravelDestinationController");
		
		List <TravelDestination> travelDestinationsByCountry = travelDestinationService.findTravelDestinationsByCountry(country);
		if (travelDestinationsByCountry.isEmpty()) {
			throw new TravelDestinationNotFoundException("Travel Destinations Not Found for the Country: " + country);
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(travelDestinationsByCountry);
	}
	
	
	@GetMapping (path ="/id/{id}")
	public ResponseEntity <TravelDestination> getTravelDestinationById (
			@PathVariable(value="id")Long id) throws TravelDestinationNotFoundException {
	
		Optional <TravelDestination> travelDestination = travelDestinationService.findTravelDestinationById(id);
		
		if ( !travelDestination.isPresent() ) {
			throw new TravelDestinationNotFoundException("Travel Destination Not Found for the ID: " + id);
		}
		
		return ResponseEntity.status(HttpStatus.FOUND).body(travelDestination.get());
	}
	

	@PutMapping(path ="/{id}")
	public String updateTravelDestination(
			@PathVariable(value="id")Long id, 
			@RequestBody TravelDestination travelDestination) throws TravelDestinationNotFoundException { 
	
		int updateCount =  travelDestinationService.updateTravelDestination(id, travelDestination);
		
		if ( updateCount < 1 ) {
			throw new TravelDestinationNotFoundException("Travel Destination Not Found for the ID: " + id);
		}
		
		if (updateCount > 0)
			 return "Travel Destination Updated Successfully For ID: " + id;
		else 
			return "Travel Destination Not Updated Successfully For ID: " + id;

	}
	
	@DeleteMapping(path ="/{id}")
	public String deleteTravelDestination( @PathVariable(value="id")Long id) throws TravelDestinationNotFoundException { 
		
		travelDestinationService.deleteTravelDestinationById(id);
		return "Travel Destination Deleted Successfully For ID: " + id;
	}
	

}
