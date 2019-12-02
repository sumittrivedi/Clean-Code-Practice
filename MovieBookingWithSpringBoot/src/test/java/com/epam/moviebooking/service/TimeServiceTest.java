package com.epam.moviebooking.service;

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

import com.epam.moviebooking.dto.TimeDto;
import com.epam.moviebooking.repository.TimeRepository;

class TimeServiceTest {
	
	@Mock
	private TimeRepository timeRepository;
	@InjectMocks
	private TimeService timeService;
	
	@BeforeEach
	public void init() 
	{
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void getTimeOfNextDay() 
	{
		List<TimeDto> timeList = new ArrayList<TimeDto>();
		TimeDto obj1 = new TimeDto(1, LocalTime.of(8, 00, 00));
		TimeDto obj2 = new TimeDto(2, LocalTime.of(10, 15, 00));
		TimeDto obj3 = new TimeDto(3, LocalTime.of(12, 00, 00));
		TimeDto obj4 = new TimeDto(4, LocalTime.of(16, 10, 00));
		TimeDto obj5 = new TimeDto(5, LocalTime.of(19, 15, 00));
		timeList.add(obj1);
		timeList.add(obj2);
		timeList.add(obj3);
		timeList.add(obj4);
		timeList.add(obj5);
		when(timeRepository.findAll()).thenReturn(timeList);
		assertEquals(timeService.getTime(LocalDate.now().plusDays(1)),timeList);
	}

}
