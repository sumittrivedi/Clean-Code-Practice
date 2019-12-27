package com.epam.moviebooking.service;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.moviebooking.dto.TheatreDto;
import com.epam.moviebooking.repository.TheatreRepository;

class TheatreServiceTest {
	
	@Mock
	TheatreRepository theatreRepository;
	@Mock
	TheatreDto dto;
	@InjectMocks
	TheatreService theatreService;
	
	@BeforeEach
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void getTheatreId() 
	{
		List<TheatreDto> theatreDtoList = new ArrayList<TheatreDto>();
		theatreDtoList.add(new TheatreDto(1,1,"PVR Cyberabad"));
		when(theatreRepository.findByTheatreName("PVR Cyberabad")).thenReturn(theatreDtoList);
		when(dto.getTheatreId()).thenReturn(1);
		assertEquals(1,theatreService.getTheatreId("PVR Cyberabad"));
	}

	@Test
	void theatreByMovie()
	{
		List<TheatreDto> theatreDtoList = new ArrayList<TheatreDto>();
		TheatreDto obj1 = new TheatreDto(1, 1, "PVR Cyberabad");
		TheatreDto obj2 = new TheatreDto(2, 1, "INOX Hitech City");
		
		theatreDtoList.add(obj1);
		theatreDtoList.add(obj2);
		
		when(theatreRepository.theatreByMovie("Hyderabad", "War")).thenReturn(theatreDtoList);
		assertEquals(theatreRepository.theatreByMovie("Hyderabad", "War"), theatreDtoList);
	}
}
