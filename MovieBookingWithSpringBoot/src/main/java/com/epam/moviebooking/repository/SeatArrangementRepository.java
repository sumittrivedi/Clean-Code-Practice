package com.epam.moviebooking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epam.moviebooking.dto.SeatArrangementDto;

@Repository
public interface SeatArrangementRepository extends CrudRepository<SeatArrangementDto, Character> {
	
	
}
