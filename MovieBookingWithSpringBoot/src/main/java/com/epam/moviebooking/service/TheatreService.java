package com.epam.moviebooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.moviebooking.entity.TheatreEntity;
import com.epam.moviebooking.repository.TheatreRepository;

@Service
public class TheatreService {

	@Autowired
	private TheatreRepository theatreRepository;
	@Autowired
	private Optional<TheatreEntity> theatreOptional;
	
	public List<TheatreEntity> theatreByMovie(String locationChoice, String movieChoice)
	{
		return theatreRepository.theatreByMovie(locationChoice, movieChoice);
	}
	
	public int getTheatreId(String theatreName)
	{
		Optional<TheatreEntity> theatreDtoOptional = theatreRepository.findByTheatreName(theatreName).stream().findFirst();
		int theatreId = 0;
		if (theatreDtoOptional.isPresent()) {
			TheatreEntity dto = theatreDtoOptional.get();
			theatreId = dto.getTheatreId();
		}
		return theatreId;
	}
	
	public List<TheatreEntity> theatreDetails()
	{
		return (List<TheatreEntity>) theatreRepository.findAll();
	}
	
	public void addTheatre(String theatreName, int locationId) 
	{
		TheatreEntity theatreDto = new TheatreEntity();
		theatreDto.setLocationId(locationId);
		theatreDto.setTheatreName(theatreName);
		theatreRepository.save(theatreDto);
	}
	public void updateTheatre(int theatreId, String theatreName, int locationId)
	{
		theatreOptional = theatreRepository.findById(theatreId);
		TheatreEntity theatreDto = null;
		if(theatreOptional.isPresent())
		{
			theatreDto = theatreOptional.get();
			theatreDto.setTheatreName(theatreName);
			theatreDto.setLocationId(locationId);
			theatreRepository.save(theatreDto);
		}
	}
	public void deleteTheatre(int theatreId)
	{
		theatreOptional = theatreRepository.findById(theatreId);
		TheatreEntity theatreEntity = null;
		if(theatreOptional.isPresent())
		{
			theatreEntity = theatreOptional.get();
			theatreRepository.delete(theatreEntity);
		}
	}
}
