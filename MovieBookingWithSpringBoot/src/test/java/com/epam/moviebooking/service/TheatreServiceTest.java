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

import com.epam.moviebooking.entity.TheatreEntity;
import com.epam.moviebooking.repository.TheatreRepository;

class TheatreServiceTest {
	
	@Mock
	TheatreRepository theatreRepository;
	@Mock
	TheatreEntity dto;
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
		List<TheatreEntity> theatreDtoList = new ArrayList<TheatreEntity>();
		theatreDtoList.add(new TheatreEntity(1,1,"PVR Cyberabad"));
		when(theatreRepository.findByTheatreName("PVR Cyberabad")).thenReturn(theatreDtoList);
		when(dto.getTheatreId()).thenReturn(1);
		assertEquals(1,theatreService.getTheatreId("PVR Cyberabad"));
	}

	@Test
	void theatreByMovie()
	{
		List<TheatreEntity> theatreDtoList = new ArrayList<TheatreEntity>();
		TheatreEntity obj1 = new TheatreEntity(1, 1, "PVR Cyberabad");
		TheatreEntity obj2 = new TheatreEntity(2, 1, "INOX Hitech City");
		
		theatreDtoList.add(obj1);
		theatreDtoList.add(obj2);
		
		when(theatreRepository.theatreByMovie("Hyderabad", "War")).thenReturn(theatreDtoList);
		assertEquals(theatreRepository.theatreByMovie("Hyderabad", "War"), theatreDtoList);
	}
}
