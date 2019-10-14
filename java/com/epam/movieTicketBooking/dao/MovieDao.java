package com.epam.movieTicketBooking.dao;

import com.epam.movieTicketBooking.daoImpl.TheatreDaoImpl;

public interface MovieDao {
	
	public void addMovies(String locationName, String theatreName, String movieName);
	

}
