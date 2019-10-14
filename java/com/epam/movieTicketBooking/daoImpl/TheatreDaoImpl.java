package com.epam.movieTicketBooking.daoImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.epam.movieTicketBooking.dao.LocationDao;
import com.epam.movieTicketBooking.dao.TheatreDao;

public class TheatreDaoImpl implements TheatreDao {
	
	HashMap< String, ArrayList<String>> theatres = new HashMap<String, ArrayList<String>>();
	
	
	public void addTheatre(String locationName, String theatreName) {
		if(theatres.containsKey(locationName))
			theatres.get(theatreName).add(theatreName);
		else {
			new LocationDaoImpl().addLocation(locationName);
			theatres.put(locationName, new ArrayList<String>(Arrays.asList(theatreName)));
			}
	}

}
