package com.epam.moviebooking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epam.moviebooking.entity.TimeEntity;

@Repository
public interface TimeRepository extends CrudRepository<TimeEntity, Integer>{

}
