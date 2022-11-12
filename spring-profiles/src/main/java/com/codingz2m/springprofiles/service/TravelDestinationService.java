package com.codingz2m.springprofiles.service;

import java.util.List;

import com.codingz2m.springprofiles.entity.TravelDestination;
import com.codingz2m.springprofiles.exception.TravelDestinationNotFoundException;

public interface TravelDestinationService {
	
	TravelDestination addTravelDestination(TravelDestination travelDestination);
	
	List<TravelDestination> findAllTravelDestinations(); 
	
	List<TravelDestination> findTravelDestinationsByCountry(String country)throws TravelDestinationNotFoundException;

	TravelDestination findTravelDestinationById(Long id) throws TravelDestinationNotFoundException;
	
	int updateTravelDestination (Long id, TravelDestination travelDestination);
	
	void deleteTravelDestinationById(Long id);
}
