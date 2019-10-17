package com.epam.movieTicketBooking.service;

import com.epam.movieTicketBooking.dao.MovieDao;
import com.epam.movieTicketBooking.daoImpl.MovieDaoImpl;

public class MovieService {
	
	MovieDao movieDao = new MovieDaoImpl();
	
	public void showMovie(String userChoice)
	{
		movieDao.showMovies(userChoice);
	}
}
