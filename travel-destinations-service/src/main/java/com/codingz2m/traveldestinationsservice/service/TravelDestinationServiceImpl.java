package com.codingz2m.traveldestinationsservice.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingz2m.traveldestinationsservice.entity.TravelDestination;
import com.codingz2m.traveldestinationsservice.exception.TravelDestinationNotFoundException;
import com.codingz2m.traveldestinationsservice.repository.TravelDestinationRepository;

@Service (value="tds")
@Transactional
public class TravelDestinationServiceImpl implements TravelDestinationService {

	private final Logger logger = LoggerFactory.getLogger(TravelDestinationServiceImpl.class );
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
		logger.info("Inside findAllTravelDestinations() of TravelDestinationServiceImpl");
		Iterable <TravelDestination> allTravelDestinations = travelDestinationRepository.findAll();
		return (List<TravelDestination>) allTravelDestinations;
	}

	@Override
	public List<TravelDestination> findTravelDestinationsByCountry(String country) throws TravelDestinationNotFoundException{
		List<TravelDestination> travelDestinations = travelDestinationRepository.findByCountry(country);
	
		return travelDestinations;
	}
	
	
	@Override
	public int updateTravelDestination(Long id, TravelDestination travelDestination) throws TravelDestinationNotFoundException {
		
		int updateCount=0;
		Optional <TravelDestination>  optionalTravelDestination  = findTravelDestinationById(id);
		
		if ( !optionalTravelDestination.isPresent() ) {
				throw new TravelDestinationNotFoundException("Travel Destination Not Found for the ID: " + id);
			}
		else {
			updateCount = travelDestinationRepository.updateTravelDestination(id, 
	 				travelDestination.getPlaceName(), travelDestination.getCountry());
		}
		return updateCount;
	}
	
	
	@Override
	public void deleteTravelDestinationById(Long id) throws TravelDestinationNotFoundException{
		
		Optional <TravelDestination>  travelDestination = findTravelDestinationById(id);
			
		if ( !travelDestination.isPresent() ) {
				throw new TravelDestinationNotFoundException("Travel Destination Not Found for the ID: " + id);
			}
		else {
			travelDestinationRepository.deleteById(id);
		}
	}
	
	
	
	@Override
	public Optional <TravelDestination> findTravelDestinationById(Long id) throws TravelDestinationNotFoundException {
		
		Optional <TravelDestination>  travelDestination = travelDestinationRepository.findById(id);
	
		return travelDestination;
	}




}
