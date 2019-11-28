package com.epam.moviebooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epam.moviebooking.dto.MovieDto;

@Repository
public interface MovieRepository extends CrudRepository<MovieDto, Integer> {

	@Query(nativeQuery = true ,value="select * from moviedetails where moviedetails.TheatreID IN(select TheatreID from theatredetails where theatredetails.LocationID IN (select LocationID from locationdetails where locationdetails.LocationName=?1))")
	List<MovieDto> movieByLocation(@Param("locationChoice") String locationChoice);
}




