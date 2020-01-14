package com.epam.moviebooking.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.moviebooking.dto.TicketBookingDto;
import com.epam.moviebooking.repository.TicketBookingRepository;

@Service
public class TicketBookingService {
	
	@Autowired
	TicketBookingRepository ticketBookingRepository; 
	
	public TicketBookingDto setTicketBookingDetails(TicketBookingDto dto) throws NoSuchAlgorithmException
	{
		Random random = SecureRandom.getInstanceStrong();
		int bookingId = random.nextInt();
		dto.setBookingId(bookingId);
		return ticketBookingRepository.save(dto);
	}

}
