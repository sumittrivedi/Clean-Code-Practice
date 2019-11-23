package com.epam.moviebooking.service;

import org.springframework.stereotype.Service;

import com.epam.moviebooking.dao.AvailableSeatDao;
import com.epam.moviebooking.daoImpl.AvailableSeatDaoImpl;
import com.epam.moviebooking.dto.AvailableSeatDto;

@Service
public class SeatAvailabilityService {
	
	
	AvailableSeatDao availableSeatDao = new AvailableSeatDaoImpl();
	
	public AvailableSeatDto getAvailableSeat(int showId)
	{
		return availableSeatDao.getAvailableSeat(showId);
	}
	public void updateSeats(AvailableSeatDto dto, int premiumSeatChoice, int executiveSeatChoice)
	{
		availableSeatDao.updateAvailableSeat(dto,premiumSeatChoice,executiveSeatChoice);
	}
	

}
