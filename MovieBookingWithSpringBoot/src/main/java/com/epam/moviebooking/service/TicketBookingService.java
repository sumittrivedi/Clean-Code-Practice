package com.epam.moviebooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.moviebooking.dto.TicketBookingDto;
import com.epam.moviebooking.repository.TicketBookingRepository;

@Service
public class TicketBookingService {
	
	@Autowired
	TicketBookingRepository ticketBookingRepository; 
	
	public void setTicketBookingDetails(TicketBookingDto dto)
	{
		ticketBookingRepository.save(dto);
	}

}
