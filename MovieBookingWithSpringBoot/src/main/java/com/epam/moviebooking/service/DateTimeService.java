package com.epam.moviebooking.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.moviebooking.dto.TimeDto;
import com.epam.moviebooking.repository.TimeRepository;

@Service
public class DateTimeService {
	
	@Autowired
	TimeRepository timeRepository;
	
	public ArrayList<String> getDate()
	{
		ArrayList<String> dates = new ArrayList<String>();
		LocalDate currentDate = LocalDate.now();
		for (int i=0; i<3 ; i++) {
			dates.add(currentDate.plusDays(i).toString());
		}
		return dates;
	}
	
	public List<TimeDto> getTime()
	{
		return (List<TimeDto>) timeRepository.findAll();
	}
}
