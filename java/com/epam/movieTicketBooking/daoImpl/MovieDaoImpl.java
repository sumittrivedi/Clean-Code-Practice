package com.epam.movieTicketBooking.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;

import com.epam.movieTicketBooking.dao.MovieDao;

public class MovieDaoImpl implements MovieDao{
	
	HashMap< Object, ArrayList<String>> movies = new HashMap<Object, ArrayList<String>>();
	
	public void addMovies(String locationName, String theatreName, String movieName) {
		
		if(new TheatreDaoImpl().theatres.containsKey(locationName))
		{
			
		}
	}

}
