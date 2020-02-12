package com.epam.moviebooking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epam.moviebooking.entity.SeatArrangementEntity;

@Repository
public interface SeatArrangementRepository extends CrudRepository<SeatArrangementEntity, Character> {
	
	
}
