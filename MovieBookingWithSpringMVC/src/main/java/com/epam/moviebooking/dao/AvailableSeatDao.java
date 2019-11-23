package com.epam.moviebooking.dao;

import com.epam.moviebooking.dto.AvailableSeatDto;

public interface AvailableSeatDao {
	
	void updateAvailableSeat(AvailableSeatDto dto, int premiumSeatChoice, int executiveSeatChoice);
	void setAvailableSeat(int showId);
	AvailableSeatDto getAvailableSeat(int showId);
	
}
