package com.epam.moviebooking.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epam.moviebooking.dto.ShowDetailsDto;

@Repository
public interface ShowDetailsRepository extends CrudRepository<ShowDetailsDto, Integer>{
	
	Optional<ShowDetailsDto> findByTheatreIdAndDateAndTime(int theatreId,String date,String time);
	
}
