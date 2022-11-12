package com.codingz2m.traveldestinationsservice.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codingz2m.traveldestinationsservice.entity.TravelDestination;

import java.util.List;


@Repository
public interface TravelDestinationRepository extends CrudRepository<TravelDestination, Long> {

	   //  Optional<TravelDestination> findById(ID id);    // Built-In method...
	  //  Iterable<TravelDestination> findAll();           // Built-In method...
	  //  TravelDestination save(TravelDestination entity);
	
      // custom finder method
	  @Query("SELECT td FROM TravelDestination td WHERE td.country = :country")
	 List<TravelDestination> findByCountry( @Param("country") String country); // Custom method...
	
	//  List<TravelDestination> findByCountry(  String country); // C
		
		// Custom Queries with @Query Annotation
		// Creating JPA-based repository layer, using Spring Data JPA
		// JPQL Update @Query
		@Modifying
		@Query("UPDATE TravelDestination td SET td.placeName = :placeName, td.country = :country WHERE "
			 		                           + "td.id = :id")
		// custom finder method
		int updateTravelDestination(@Param("id") Long id, @Param("placeName") String placeName, @Param("country") String country);
	  
	 }

