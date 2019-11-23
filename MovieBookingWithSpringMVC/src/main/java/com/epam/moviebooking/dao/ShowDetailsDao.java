package com.epam.moviebooking.dao;

import com.epam.moviebooking.dto.ShowDetailsDto;

public interface ShowDetailsDao {
	
	int getShowId(int theatreId,String date,String time);
	void setShowId(ShowDetailsDto showDetailsDto);
}
