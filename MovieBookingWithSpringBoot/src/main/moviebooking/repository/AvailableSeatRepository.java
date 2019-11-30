package com.epam.moviebooking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epam.moviebooking.dto.AvailableSeatDto;

@Repository
public interface AvailableSeatRepository extends CrudRepository<AvailableSeatDto, Integer> {
	
	
}
