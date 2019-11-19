package service;

import dao.TicketBookingDao;
import daoImpl.TicketBookingDaoImpl;
import dto.TicketBookingDto;

public class TicketBookingService {
	
	TicketBookingDao ticketBookingDao = new TicketBookingDaoImpl();
	
	public  void setTicketBookingDetails(TicketBookingDto ticketBookingDto)
	{
		ticketBookingDao.setTicketBookingDetails(ticketBookingDto);
	}

	public  void getTicketBookingDetails(int bookingId)
	{
		ticketBookingDao.getTicketBookingDetails(bookingId);
	}
	
}
