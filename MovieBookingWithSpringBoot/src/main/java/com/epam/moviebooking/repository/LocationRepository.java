package com.epam.moviebooking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epam.moviebooking.entity.LocationEntity;

@Repository
public interface LocationRepository extends CrudRepository<LocationEntity, Integer> {
	
}
