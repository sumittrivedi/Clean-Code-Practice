package com.epam.moviebooking.restcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.epam.moviebooking.entity.TheatreEntity;
import com.epam.moviebooking.service.TheatreService;
import com.epam.moviebooking.webservices.restcontroller.TheatreRestController;

@SpringBootTest
class TheatreRestControllerTest {
	@Mock
	private TheatreService theatreService;
	@InjectMocks
	private TheatreRestController theatreRestController;
	
	void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void getTheatre() 
	{
		String locationChoice = "Hyderabad"; 
		String movieChoice = "War";
		List<TheatreEntity> theatreEntities = new ArrayList<>();
		TheatreEntity theatreEntity = new TheatreEntity();
		theatreEntity.setLocationId(1);
		theatreEntity.setTheatreId(1);
		theatreEntity.setTheatreName("PVR Cyberabad");
		theatreEntities.add(theatreEntity);		
		when(theatreService.theatreByMovie(locationChoice, movieChoice)).thenReturn(theatreEntities);
		ResponseEntity<List<TheatreEntity>> responseEntity = theatreRestController.getTheatre(locationChoice, movieChoice);
		assertEquals(responseEntity, theatreRestController.getTheatre(locationChoice, movieChoice));
	}

	@Test
	void theatreDetails() 
	{
		List<TheatreEntity> theatreEntities = new ArrayList<>();
		TheatreEntity theatreEntity = new TheatreEntity();
		theatreEntity.setLocationId(1);
		theatreEntity.setTheatreId(1);
		theatreEntity.setTheatreName("PVR Cyberabad");
		theatreEntities.add(theatreEntity);		
		when(theatreService.theatreDetails()).thenReturn(theatreEntities);
		ResponseEntity<List<TheatreEntity>> responseEntity = theatreRestController.theatreDetails();
		assertEquals(responseEntity, theatreRestController.theatreDetails());
	}

}
