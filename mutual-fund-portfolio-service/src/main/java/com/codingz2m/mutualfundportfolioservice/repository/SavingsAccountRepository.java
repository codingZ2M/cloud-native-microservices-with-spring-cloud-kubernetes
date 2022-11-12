package com.codingz2m.mutualfundportfolioservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsAccountRepository  extends CrudRepository<SavingsAccount, Long> {
	
	

}
