package com.epam.movieTicketBooking.service;

import com.epam.movieTicketBooking.daoImpl.MovieDaoImpl;

public class MovieService {
	
	public void showMovie(String userChoice)
	{
		new MovieDaoImpl().showMovies(userChoice);
	}
	public void addMovie()
	{
		new MovieDaoImpl().addMovies();
	}

}
