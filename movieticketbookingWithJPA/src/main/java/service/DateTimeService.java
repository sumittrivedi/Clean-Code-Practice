package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.TimeDao;
import daoImpl.TimeDaoImpl;

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
