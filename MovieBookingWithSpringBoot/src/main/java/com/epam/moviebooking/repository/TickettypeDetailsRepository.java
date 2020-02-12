package com.epam.moviebooking.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epam.moviebooking.entity.TickettypeEntity;

@Repository
public interface TickettypeDetailsRepository extends CrudRepository<TickettypeEntity, String>{
	
	@Query(value = "SELECT cost FROM tickettypedetails where category = (select seatCategory from seatrowDetails where rowId = ?1)",nativeQuery = true)
	Double getSeatCost(@Param("rowId") String rowId);

}
