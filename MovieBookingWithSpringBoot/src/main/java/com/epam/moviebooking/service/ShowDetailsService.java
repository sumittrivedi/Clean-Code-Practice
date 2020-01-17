package com.epam.moviebooking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.moviebooking.entity.ShowDetailsEntity;
import com.epam.moviebooking.repository.ShowDetailsRepository;

@Service
public class ShowDetailsService {
	
	@Autowired
	private ShowDetailsRepository showDetailsRepository;
	@Autowired
	private Optional<ShowDetailsEntity> showDetailsOptional;
	@Autowired
	private ShowDetailsEntity showDetailsEntity;
	
	public int getShowId(int theatreId,String date,String time)
	{	
		showDetailsOptional = showDetailsRepository.findByTheatreIdAndDateAndTime(theatreId,date,time);
		if(! showDetailsOptional.isPresent())
		{
			showDetailsEntity.setTheatreId(theatreId);
			showDetailsEntity.setDate(date);
			showDetailsEntity.setTime(time);
			this.setShowId(showDetailsEntity);
			showDetailsOptional = showDetailsRepository.findByTheatreIdAndDateAndTime(theatreId,date,time);
		}
		if(showDetailsOptional.isPresent())
			showDetailsEntity = showDetailsOptional.get();
		return showDetailsEntity.getShowId();
	}
	
	private void setShowId(ShowDetailsEntity showDetailsDto)
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
		String bookedSeats = this.getBookedSeats(theatreId, date, time);
		Optional<String> bookedSeatsOptional = Optional.ofNullable(bookedSeats);
		if (bookedSeatsOptional.isPresent()) 
		{
			Optional<ShowDetailsEntity> dto = showDetailsRepository.findByTheatreIdAndDateAndTime(theatreId, date, time);
			seatIds.append(bookedSeats);
			if (dto.isPresent())
			{
				dto.get().setBookedSeats(seatIds.toString());
				showDetailsRepository.save(dto.get());
			}
				
		}
		else
		{
			showDetailsEntity.setTheatreId(theatreId);
			showDetailsEntity.setDate(date);
			showDetailsEntity.setTime(time);
			showDetailsEntity.setBookedSeats(seatIds.toString());
			showDetailsRepository.save(showDetailsEntity);
		}
	}
}
