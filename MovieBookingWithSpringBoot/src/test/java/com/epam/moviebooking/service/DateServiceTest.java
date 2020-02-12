package com.epam.moviebooking.service;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class DateServiceTest {
	
	@InjectMocks
	private DateService dateService;
	
	@BeforeEach
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void getDate() 
	{
		List<LocalDate> dates = new ArrayList<LocalDate>();
		dates.add(LocalDate.now());
		dates.add(LocalDate.now().plusDays(1));
		dates.add(LocalDate.now().plusDays(2));
		
		assertEquals(dateService.getDate(), dates);
	}

}
