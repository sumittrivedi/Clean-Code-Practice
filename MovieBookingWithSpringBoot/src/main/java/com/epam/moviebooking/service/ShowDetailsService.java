package com.epam.moviebooking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.moviebooking.dto.ShowDetailsDto;
import com.epam.moviebooking.repository.ShowDetailsRepository;

@Service
public class ShowDetailsService {
	
	@Autowired
	ShowDetailsService ShowDetailsService;
	@Autowired
	ShowDetailsRepository showDetailsRepository;
	@Autowired
	Optional<ShowDetailsDto> showDetailsOptional;
	@Autowired
	ShowDetailsDto showDetailDto;
	
	public int getShowId(int theatreId,String date,String time)
	{	
		showDetailsOptional = showDetailsRepository.findByTheatreIdAndDateAndTime(theatreId,date,time);
		if(showDetailsOptional.isPresent() == false)
		{
			showDetailDto.setTheatreId(theatreId);
			showDetailDto.setDate(date);
			showDetailDto.setTime(time);
			ShowDetailsService.setShowId(showDetailDto);
			showDetailsOptional = showDetailsRepository.findByTheatreIdAndDateAndTime(theatreId,date,time);
		}
		return showDetailsOptional.get().getShowId();
	}
	
	private void setShowId(ShowDetailsDto showDetailsDto)
	{
		showDetailsRepository.save(showDetailsDto);
	}
	
	public String getBookedSeats(int theatreId,String date,String time)
	{
		String bookedSeats = null;
		showDetailsOptional = showDetailsRepository.findByTheatreIdAndDateAndTime(theatreId,date,time);
		if(showDetailsOptional.isPresent())
			bookedSeats = showDetailsOptional.get().getBookedSeats();
		return bookedSeats;
	}

}
