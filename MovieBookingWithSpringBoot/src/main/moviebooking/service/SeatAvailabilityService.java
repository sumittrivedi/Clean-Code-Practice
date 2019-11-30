package com.epam.moviebooking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.moviebooking.dto.AvailableSeatDto;
import com.epam.moviebooking.repository.AvailableSeatRepository;

@Service
public class SeatAvailabilityService {
	
	@Autowired
	private SeatAvailabilityService SeatAvailabilityService;
	@Autowired
	private AvailableSeatRepository availableSeatRepository; 
	@Autowired
	private Optional<AvailableSeatDto> availableSeatOptional;
	@Autowired
	private AvailableSeatDto availableSeatDto;
	
	public AvailableSeatDto getAvailableSeat(int showId)
	{	
		availableSeatOptional = availableSeatRepository.findById(showId);	
		if(availableSeatOptional.isPresent() == false)
		{
			availableSeatDto.setShowId(showId);
			availableSeatDto.setPremiumAvailability(20);
			availableSeatDto.setExecutiveAvailabilty(80);
			SeatAvailabilityService.setAvailableSeat(availableSeatDto);
		}
		availableSeatOptional = availableSeatRepository.findById(showId);
		return availableSeatOptional.get();
		
	}
	public void updateSeats(AvailableSeatDto availableSeatDto, int premiumSeatChoice, int executiveSeatChoice)
	{
		int showId = availableSeatDto.getShowId();
		AvailableSeatDto availableSeatObj = availableSeatRepository.findById(showId).get();	
		int executiveAvailabilty = availableSeatObj.getExecutiveAvailabilty();
		int premiumAvailability = availableSeatObj.getPremiumAvailability();	
		availableSeatObj.setExecutiveAvailabilty(executiveAvailabilty-executiveSeatChoice);
		availableSeatObj.setPremiumAvailability(premiumAvailability-premiumSeatChoice);
		availableSeatRepository.save(availableSeatObj);
	}
	private void setAvailableSeat(AvailableSeatDto availableSeatDto)
	{
		availableSeatRepository.save(availableSeatDto);
	}

}
