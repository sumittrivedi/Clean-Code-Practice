package com.epam.moviebooking.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.moviebooking.dto.AvailableSeatDto;
import com.epam.moviebooking.repository.AvailableSeatRepository;

class SeatAvailabilityServiceTest {

	@Mock
	private AvailableSeatRepository availableSeatRepository;
	@Mock
	private AvailableSeatDto availableSeatDto;
	@InjectMocks
	private SeatAvailabilityService seatAvailabilityService;
	
	@BeforeEach
	private void init() 
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void getAvailableSeat() 
	{
		availableSeatDto.setShowId(184);
		availableSeatDto.setExecutiveAvailabilty(0);
		availableSeatDto.setPremiumAvailability(3);
		when(availableSeatRepository.findById(184)).thenReturn(Optional.of(availableSeatDto));
		assertEquals(seatAvailabilityService.getAvailableSeat(184), availableSeatDto);
	}

}
