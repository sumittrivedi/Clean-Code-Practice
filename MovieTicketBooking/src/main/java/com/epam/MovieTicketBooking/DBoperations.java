package com.epam.MovieTicketBooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DBoperations {
	
	public void insert(List element, Object data);
	public void insert(HashMap<String, ArrayList<String>> element, String key, String value);
	public void update(Object element);
	public void delete(Object element);
	public void display(Object element);
	public void display(Object element,Object choice);
}
