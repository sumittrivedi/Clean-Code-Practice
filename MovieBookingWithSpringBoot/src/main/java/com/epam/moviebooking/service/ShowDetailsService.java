package com.epam.moviebooking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.moviebooking.dto.ShowDetailsDto;
import com.epam.moviebooking.repository.ShowDetailsRepository;

@Service
public class ShowDetailsService {
	
	@Autowired
	private ShowDetailsService showDetailsService;
	@Autowired
	private ShowDetailsRepository showDetailsRepository;
	@Autowired
	private Optional<ShowDetailsDto> showDetailsOptional;
	@Autowired
	private ShowDetailsDto showDetailsDto;
	
	public int getShowId(int theatreId,String date,String time)
	{	
		showDetailsOptional = showDetailsRepository.findByTheatreIdAndDateAndTime(theatreId,date,time);
		if(! showDetailsOptional.isPresent())
		{
			showDetailsDto.setTheatreId(theatreId);
			showDetailsDto.setDate(date);
			showDetailsDto.setTime(time);
			showDetailsService.setShowId(showDetailsDto);
			showDetailsOptional = showDetailsRepository.findByTheatreIdAndDateAndTime(theatreId,date,time);
		}
		if(showDetailsOptional.isPresent())
			showDetailsDto = showDetailsOptional.get();
		return showDetailsDto.getShowId();
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
	
	public void updateBookedSeats(int theatreId,String date,String time,String selectedSeats)
	{
		StringBuilder seatIds = new StringBuilder(selectedSeats);
		String bookedSeats = showDetailsService.getBookedSeats(theatreId, date, time);
		Optional<String> bookedSeatsOptional = Optional.ofNullable(bookedSeats);
		if (bookedSeatsOptional.isPresent()) 
		{
			Optional<ShowDetailsDto> dto = showDetailsRepository.findByTheatreIdAndDateAndTime(theatreId, date, time);
			seatIds.append(bookedSeats);
			if (dto.isPresent())
			{
				dto.get().setBookedSeats(seatIds.toString());
				showDetailsRepository.save(dto.get());
			}
				
		}
		else
		{
			showDetailsDto.setTheatreId(theatreId);
			showDetailsDto.setDate(date);
			showDetailsDto.setTime(time);
			showDetailsDto.setBookedSeats(seatIds.toString());
			showDetailsRepository.save(showDetailsDto);
		}
	}
}
