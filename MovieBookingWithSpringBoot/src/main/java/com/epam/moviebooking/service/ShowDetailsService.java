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
	Optional<ShowDetailsDto> showDetailsDto;
	
	public int getShowId(int theatreId,String date,String time)
	{	
		if(showDetailsDto.isPresent() == false)
		{
			ShowDetailsDto dto = new ShowDetailsDto();
			dto.setTheatreId(theatreId);
			dto.setDate(date);
			dto.setTime(time);
			ShowDetailsService.setShowId(dto);
		}
		showDetailsDto = showDetailsRepository.findByTheatreIdAndDateAndTime(theatreId,date,time);
		return showDetailsDto.get().getShowId();
	}
	
	private void setShowId(ShowDetailsDto showDetailsDto)
	{
		showDetailsRepository.save(showDetailsDto);
	}

}
