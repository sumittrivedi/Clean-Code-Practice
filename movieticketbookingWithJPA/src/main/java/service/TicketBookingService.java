package service;

import dao.TicketBookingDao;
import daoImpl.TicketBookingDaoImpl;
import dto.TicketBookingDto;

public class TicketBookingService {
	
	TicketBookingDao ticketBookingDao = new TicketBookingDaoImpl();
	
	public void setTicketBookingDetails(TicketBookingDto dto)
	{
		ticketBookingDao.setTicketBookingDetails(dto);
	}

}
