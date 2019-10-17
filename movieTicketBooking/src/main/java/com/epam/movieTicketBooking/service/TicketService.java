package com.epam.movieTicketBooking.service;

import com.epam.movieTicketBooking.dao.TicketDao;
import com.epam.movieTicketBooking.daoImpl.TicketDaoImpl;

public class TicketService {

	TicketDao ticketDao = new TicketDaoImpl();
	public double calculatePrice(String ticketType, int noOfSeats) {
		return ticketDao.calculatePrice(ticketType, noOfSeats);
	}
	
	public void showTicketType() {
		ticketDao.showTicketType();
	}
}
