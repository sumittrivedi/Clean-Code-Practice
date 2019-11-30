package com.epam.moviebooking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epam.moviebooking.dto.TicketBookingDto;

@Repository
public interface TicketBookingRepository extends CrudRepository<TicketBookingDto, Integer> {
	
}
