package com.epam.moviebooking.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.moviebooking.dto.TicketBookingDto;
import com.epam.moviebooking.repository.TicketBookingRepository;

class TicketPriceServiceTest {

	@Mock
	private TicketBookingRepository ticketBookingRepository;
	@Mock
	private TicketBookingDto dto;
	
	@InjectMocks
	private TicketBookingService ticketBookingService;
	
	@BeforeEach
	void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void setTicketBookingDetails() throws NoSuchAlgorithmException 
	{
		when(ticketBookingRepository.save(dto)).thenReturn(dto);
		assertEquals(ticketBookingService.setTicketBookingDetails(dto), dto);
	}

}
