package com.epam.MovieTicketBooking;

public interface DBoperations {
	
	public void insert(Object element);
	public void update(Object element);
	public void delete(Object element);
	public void display(Object element);
	public void display(Object element,Object choice);
}
