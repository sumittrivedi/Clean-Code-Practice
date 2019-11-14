package service;

import java.time.LocalDate;
import java.util.ArrayList;

import dao.TimeDao;
import daoImpl.TimeDaoImpl;
import dto.TimeDto;

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
	
	public ArrayList<TimeDto> getTime()
	{
		return timeDao.getTime();
	}
}
