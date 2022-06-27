package com.ppdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ppdm.dto.PpdmDTO;

//PpdmJpaRepository inherits all of JpaRepository’s
//CRUD methods for working with PpdmDTO persistence.

@Repository
public interface PpdmJpaRepository extends JpaRepository<PpdmDTO, Long>{
	
	PpdmDTO findByppdmAlgorithmName(String name);
	
	PpdmDTO deleteByppdmAlgorithmName(String name);

}
