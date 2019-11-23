package com.epam.moviebooking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epam.moviebooking.dao.TheatreDao;
import com.epam.moviebooking.daoImpl.TheatreDaoImpl;

@Service
public class TheatreService {

	TheatreDao theatreDao = new TheatreDaoImpl();
	public List<String> theatreByMovie(String locationChoice, String movieChoice)
	{
		return theatreDao.theatreByMovie(locationChoice, movieChoice);
	}
	public int getTheatreId(String theatreName)
	{
		return theatreDao.getTheatreId(theatreName);
	}
}
