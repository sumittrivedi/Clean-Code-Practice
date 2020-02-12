package com.epam.moviebooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epam.moviebooking.entity.TheatreEntity;

@Repository
public interface TheatreRepository extends CrudRepository<TheatreEntity, Integer>{


	@Query(value="SELECT * from theatredetails where LocationID in (select LocationID from locationdetails where LocationName = ?1) and theatreId in (select theatreId from moviedetails where MovieName = ?2)",nativeQuery = true)
	List<TheatreEntity> theatreByMovie(@Param("locationChoice")String locationChoice, @Param("movieChoice")String movieChoice);

	List<TheatreEntity> findByTheatreName(String theatreName);

	
}
