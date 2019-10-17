package com.epam.movieTicketBooking.daoImpl;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.movieTicketBooking.dao.TicketDao;
import com.epam.movieTicketBooking.dto.TicketDto;
import com.epam.movieTicketBooking.utilities.CollectionDB;

public class TicketDaoImpl implements TicketDao {
	
	private static final Logger logger = LoggerFactory.getLogger(TicketDaoImpl.class);

	

	public double calculatePrice(String ticketType, int noOfSeats) {

		double totalPrice = 0.00;
		if (ticketType.equalsIgnoreCase("Premium"))
			totalPrice = 200 * noOfSeats;
		else if (ticketType.equalsIgnoreCase("Executive"))
			totalPrice = 150 * noOfSeats;
		return totalPrice;
	}
	public void showTicketType()
	{
		Iterator<TicketDto> iterator = CollectionDB.ticket.iterator();
		while (iterator.hasNext())
			logger.info(iterator.next().getTicketType());
	}
}
