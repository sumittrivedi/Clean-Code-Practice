package com.epam.moviebooking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epam.moviebooking.dto.TimeDto;

@Repository
public interface TimeRepository extends CrudRepository<TimeDto, Integer>{

}
