package com.epam.moviebooking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epam.moviebooking.dao.MovieDao;
import com.epam.moviebooking.daoImpl.MovieDaoImpl;

@Service
public class MovieService {
	
	MovieDao movieDao = new MovieDaoImpl();
	
	public List<String> movieByLocation(String locationChoice)
	{
		return movieDao.movieByLocation(locationChoice);
	}
}
