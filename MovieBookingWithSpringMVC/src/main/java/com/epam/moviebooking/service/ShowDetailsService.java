package com.epam.moviebooking.service;

import org.springframework.stereotype.Service;

import com.epam.moviebooking.dao.ShowDetailsDao;
import com.epam.moviebooking.daoImpl.ShowDetailsDaoImpl;

@Service
public class ShowDetailsService {
	
	ShowDetailsDao showDetailsDao = new ShowDetailsDaoImpl();
	
	public int getShowId(int theatreId,String date,String time)
	{
		return showDetailsDao.getShowId(theatreId, date, time);
	}

}
