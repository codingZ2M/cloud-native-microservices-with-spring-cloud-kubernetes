package com.codingz2m.savingsaccount.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SavingsAccountRepository extends CrudRepository<SavingsAccount, Long> {
	
	// Using Spring Data JPA @Query
		// Custom Queries with @Query Annotation
		// Creating JPA-based repository layer, using Spring Data JPA
		
		 // JPQL Update @Query
	    @Modifying
		@Query("UPDATE SavingsAccount sa SET sa.currentValue = :currentValue WHERE "
		 		                           + "sa.id = :id")
	    int updateSavingsAccount(@Param("id") Long id, @Param("currentValue") double currentValue);
		
	    @Query("SELECT currentValue FROM  SavingsAccount sa WHERE sa.id = :id")
	    double getSavingsAccountCurrentValue(@Param("id") Long id);
	    
	   
}
