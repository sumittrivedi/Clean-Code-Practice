package com.epam.movieTicketBooking.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.epam.movieTicketBooking.dto.LocationDto;
import com.epam.movieTicketBooking.dto.MovieDto;

public class CollectionDB {
	
	public static HashSet<LocationDto> locations = new HashSet<LocationDto>();
	public static HashMap<String, ArrayList<String>> movies= new HashMap<String, ArrayList<String>>();
	public static HashMap<MovieDto, String> theatres = new HashMap<MovieDto, String>();
	
}