package com.epam.moviebooking.service;

import org.springframework.stereotype.Service;

import com.epam.moviebooking.dao.TicketBookingDao;
import com.epam.moviebooking.daoImpl.TicketBookingDaoImpl;
import com.epam.moviebooking.dto.TicketBookingDto;

@Service
public class TicketBookingService {
	
	TicketBookingDao ticketBookingDao = new TicketBookingDaoImpl();
	
	public void setTicketBookingDetails(TicketBookingDto dto)
	{
		ticketBookingDao.setTicketBookingDetails(dto);
	}

}
