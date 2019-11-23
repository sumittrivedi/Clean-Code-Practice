package com.epam.moviebooking.dao;

import java.util.List;

public interface MovieDao {
	
	List<String> movieByLocation(String locationChoice);
}
