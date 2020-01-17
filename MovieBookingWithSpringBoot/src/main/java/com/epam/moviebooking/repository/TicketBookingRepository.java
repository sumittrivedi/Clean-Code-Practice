package com.epam.moviebooking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epam.moviebooking.entity.TicketBookingEntity;

@Repository
public interface TicketBookingRepository extends CrudRepository<TicketBookingEntity, Integer> {
	
}
