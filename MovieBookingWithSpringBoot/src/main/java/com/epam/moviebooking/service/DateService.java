package com.epam.moviebooking.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class DateService {
	
	public List<LocalDate> getDate()
	{
		List<LocalDate> dates = new ArrayList<>();
		LocalDate currentDate = LocalDate.now();
		for (int i=0; i<3 ; i++) {
			dates.add(currentDate.plusDays(i));
		}
		return dates;
	}
	
}
