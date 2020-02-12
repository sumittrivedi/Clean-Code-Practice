package com.epam.moviebooking.restcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.epam.moviebooking.entity.TimeEntity;
import com.epam.moviebooking.service.TimeService;
import com.epam.moviebooking.webservices.restcontroller.TimeRestController;

class TimeRestControllerTest {
	
	@Mock
	private TimeService timeService;
	@InjectMocks
	private TimeRestController timeRestController;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	List<TimeEntity> timeEntities = new ArrayList<>();
	TimeEntity timeEntity = new TimeEntity();
	
	@Test
	void getTime() 
	{
		String dateChoice = "2020-01-28";
		LocalDate date = LocalDate.parse(dateChoice);	
		timeEntity.setTimeId(1);
		timeEntity.setTime(LocalTime.now());
		timeEntities.add(timeEntity);
		when(timeService.getTime(date)).thenReturn(timeEntities);
		ResponseEntity<List<TimeEntity>> responseEntity = timeRestController.getTime(dateChoice);
		assertEquals(responseEntity, timeRestController.getTime(dateChoice));
	}
	
	@Test
	void timeDeatils()
	{	
		timeEntity.setTimeId(1);
		timeEntity.setTime(LocalTime.now());
		timeEntities.add(timeEntity);
		when(timeService.timeDetails()).thenReturn(timeEntities);
		ResponseEntity<List<TimeEntity>> responseEntity = timeRestController.timeDetails();
		assertEquals(responseEntity, timeRestController.timeDetails());
	}

}
