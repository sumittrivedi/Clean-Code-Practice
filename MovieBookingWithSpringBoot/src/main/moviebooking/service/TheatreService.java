package com.epam.moviebooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.moviebooking.dto.TheatreDto;
import com.epam.moviebooking.repository.TheatreRepository;

@Service
public class TheatreService {

	@Autowired
	TheatreRepository theatreRepository;
	
	public List<TheatreDto> theatreByMovie(String locationChoice, String movieChoice)
	{
		return theatreRepository.theatreByMovie(locationChoice, movieChoice);
	}
	
	public int getTheatreId(String theatreName)
	{
		TheatreDto dto = theatreRepository.findByTheatreName(theatreName).stream().findFirst().orElse(null);
		return dto.getTheatreId();
	}
}
