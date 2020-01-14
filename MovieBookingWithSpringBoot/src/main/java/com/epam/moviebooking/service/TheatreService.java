package com.epam.moviebooking.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.moviebooking.dto.TheatreDto;
import com.epam.moviebooking.repository.TheatreRepository;

@Service
public class TheatreService {

	@Autowired
	private TheatreRepository theatreRepository;
	
	public List<TheatreDto> theatreByMovie(String locationChoice, String movieChoice)
	{
		return theatreRepository.theatreByMovie(locationChoice, movieChoice);
	}
	
	public int getTheatreId(String theatreName)
	{
		Optional<TheatreDto> theatreDtoOptional = theatreRepository.findByTheatreName(theatreName).stream().findFirst();
		int theatreId = 0;
		if (theatreDtoOptional.isPresent()) {
			TheatreDto dto = theatreDtoOptional.get();
			theatreId = dto.getTheatreId();
		}
		return theatreId;
	}
	
	public List<TheatreDto> theatreDetails()
	{
		return (List<TheatreDto>) theatreRepository.findAll();
	}
	
	public void addTheatre(String theatreName, int locationId) throws NoSuchAlgorithmException
	{
		TheatreDto theatreDto = new TheatreDto();
		Random random = SecureRandom.getInstanceStrong();
		int theatreId = random.nextInt();
		theatreDto.setLocationId(locationId);
		theatreDto.setTheatreId(theatreId);
		theatreDto.setTheatreName(theatreName);
		theatreRepository.save(theatreDto);
	}
	public void updateTheatre(int theatreId, String theatreName, int locationId)
	{
		TheatreDto theatreDto = theatreRepository.findById(theatreId).get();
		theatreDto.setTheatreName(theatreName);
		theatreDto.setLocationId(locationId);
		theatreRepository.save(theatreDto);
	}
	public void deleteTheatre(int theatreId)
	{
		TheatreDto theatreDto = theatreRepository.findById(theatreId).get();
		theatreRepository.delete(theatreDto);
	}
}
