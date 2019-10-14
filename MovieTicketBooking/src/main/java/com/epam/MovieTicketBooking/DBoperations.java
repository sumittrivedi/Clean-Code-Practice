package com.epam.MovieTicketBooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DBoperations {
	
	public void setLocation(String locationName);
	//public void setMovies(String locationName,String theatreName,String movieName);
	
	public void display(Object element);
	public void display(Object element,Object choice);
}
