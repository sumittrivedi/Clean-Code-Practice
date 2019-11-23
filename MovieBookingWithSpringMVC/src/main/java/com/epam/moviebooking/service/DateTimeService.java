package com.epam.moviebooking.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.epam.moviebooking.dao.TimeDao;
import com.epam.moviebooking.daoImpl.TimeDaoImpl;

@Service
public class DateTimeService {
	
	TimeDao timeDao = new TimeDaoImpl();
	
	public ArrayList<String> getDate()
	{
		ArrayList<String> dates = new ArrayList<String>();
		LocalDate currentDate = LocalDate.now();
		for (int i=0; i<3 ; i++) {
			dates.add(currentDate.plusDays(i).toString());
		}
		return dates;
	}
	
	public List<String> getTime()
	{
		return timeDao.getTime();
	}
}
