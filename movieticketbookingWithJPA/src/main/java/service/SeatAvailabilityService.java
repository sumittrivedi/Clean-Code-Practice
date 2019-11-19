package service;

import dao.AvailableSeatDao;
import daoImpl.AvailableSeatDaoImpl;
import dto.AvailableSeatDto;

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
