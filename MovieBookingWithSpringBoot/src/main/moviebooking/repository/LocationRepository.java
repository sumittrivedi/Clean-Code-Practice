package com.epam.moviebooking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epam.moviebooking.dto.LocationDto;

@Repository
public interface LocationRepository extends CrudRepository<LocationDto, Integer> {
	
}
