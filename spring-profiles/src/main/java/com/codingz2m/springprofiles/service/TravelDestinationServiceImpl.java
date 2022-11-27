package com.codingz2m.springprofiles.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingz2m.springprofiles.controllers.TravelDestinationController;
import com.codingz2m.springprofiles.entity.TravelDestination;
import com.codingz2m.springprofiles.exception.TravelDestinationNotFoundException;
import com.codingz2m.springprofiles.repository.TravelDestinationRepository;

import jakarta.transaction.Transactional;

@Service (value="tds")
@Transactional
public class TravelDestinationServiceImpl implements TravelDestinationService {

	private final Logger logger = LoggerFactory.getLogger(TravelDestinationController.class );
	private TravelDestinationRepository travelDestinationRepository;
	
	@Autowired
	public TravelDestinationServiceImpl(TravelDestinationRepository travelDestinationRepository) {
		super();
		this.travelDestinationRepository = travelDestinationRepository;
	}
     
	
	@Override
	public TravelDestination addTravelDestination(TravelDestination travelDestination) {
		logger.info("Inside addTravelDestination() of TravelDestinationServiceImpl");
		travelDestination = travelDestinationRepository.save(travelDestination);
		return travelDestination;
	}

	@Override
	public List<TravelDestination> findAllTravelDestinations() {
		Iterable <TravelDestination> allTravelDestinations = travelDestinationRepository.findAll();
		return (List<TravelDestination>) allTravelDestinations;
	}

	@Override
	public List<TravelDestination> findTravelDestinationsByCountry(String country) throws TravelDestinationNotFoundException{
		List<TravelDestination> travelDestinations = travelDestinationRepository.findByCountry(country);
		if (travelDestinations.isEmpty()) {
			throw new TravelDestinationNotFoundException("Travel Destinations Not Found for the Country: " + country);
		}
		return travelDestinations;
	}
	
	
	@Override
	public int updateTravelDestination(Long id, TravelDestination travelDestination) {
		int updateCount=0;
		if( travelDestination.getPlaceName().equals("") || travelDestination.getCountry().equals("") ) {
				 updateCount = 0;
		}
		else {
			updateCount = travelDestinationRepository.updateTravelDestination(id, 
	 				travelDestination.getPlaceName(), travelDestination.getCountry());
		}
		return updateCount;
	}
	
	
	@Override
	public void deleteTravelDestinationById(Long id) {
		travelDestinationRepository.deleteById(id);
	}
	
	@Override
	public TravelDestination findTravelDestinationById(Long id) throws TravelDestinationNotFoundException {
		Optional <TravelDestination>  travelDestination = travelDestinationRepository.findById(id);
		if (!travelDestination.isPresent()) {
			throw new TravelDestinationNotFoundException("Travel Destination Not Found for the ID: " + id);
		}
		return travelDestination.get();
	}




}
