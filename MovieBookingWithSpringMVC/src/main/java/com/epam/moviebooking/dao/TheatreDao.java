package com.epam.moviebooking.dao;

import java.util.List;

public interface TheatreDao {
	
	int getTheatreId(String theatreName);
	List<String> theatreByMovie(String locationChoice, String movieChoice);
}
