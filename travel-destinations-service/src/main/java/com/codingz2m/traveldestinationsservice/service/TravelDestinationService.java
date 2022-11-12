package com.codingz2m.traveldestinationsservice.service;

import java.util.List;
import java.util.Optional;

import com.codingz2m.traveldestinationsservice.entity.TravelDestination;
import com.codingz2m.traveldestinationsservice.exception.TravelDestinationNotFoundException;


public interface TravelDestinationService {
	
	TravelDestination addTravelDestination(TravelDestination travelDestination);
	
	List<TravelDestination> findAllTravelDestinations(); 
	
	List<TravelDestination> findTravelDestinationsByCountry(String country) throws TravelDestinationNotFoundException;

	Optional <TravelDestination> findTravelDestinationById(Long id) throws TravelDestinationNotFoundException;
	
	int updateTravelDestination (Long id, TravelDestination travelDestination) throws TravelDestinationNotFoundException;
	
//	int updateTravelDestinationByCountry (String country, TravelDestination travelDestination);
	
	void deleteTravelDestinationById(Long id) throws TravelDestinationNotFoundException;
}

