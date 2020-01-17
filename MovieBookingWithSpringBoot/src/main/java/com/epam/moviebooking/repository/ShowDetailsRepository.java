package com.epam.moviebooking.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epam.moviebooking.entity.ShowDetailsEntity;

@Repository
public interface ShowDetailsRepository extends CrudRepository<ShowDetailsEntity, Integer>{
	
	Optional<ShowDetailsEntity> findByTheatreIdAndDateAndTime(int theatreId,String date,String time);
	
}
