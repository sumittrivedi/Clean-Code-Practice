package com.epam.moviebooking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.moviebooking.dto.AvailableSeatDto;
import com.epam.moviebooking.repository.AvailableSeatRepository;

@Service
public class SeatAvailabilityService {
	
	@Autowired
	SeatAvailabilityService SeatAvailabilityService;
	@Autowired
	AvailableSeatRepository availableSeatRepository; 
	@Autowired
	Optional<AvailableSeatDto> availableSeatDto;
	
	public AvailableSeatDto getAvailableSeat(int showId)
	{	
		availableSeatDto = availableSeatRepository.findById(showId);	
		if(availableSeatDto.isPresent() == false)
		{
			AvailableSeatDto dto = new AvailableSeatDto();
			dto.setShowId(showId);
			dto.setPremiumAvailability(20);
			dto.setExecutiveAvailabilty(80);
			SeatAvailabilityService.setAvailableSeat(dto);
		}
		availableSeatDto = availableSeatRepository.findById(showId);
		return availableSeatDto.get();
		
	}
	public void updateSeats(AvailableSeatDto dto, int premiumSeatChoice, int executiveSeatChoice)
	{
		int showId = dto.getShowId();
		AvailableSeatDto dto1 = availableSeatRepository.findById(showId).get();	
		int executiveAvailabilty = dto1.getExecutiveAvailabilty();
		int premiumAvailability = dto1.getPremiumAvailability();	
		dto1.setExecutiveAvailabilty(executiveAvailabilty-executiveSeatChoice);
		dto1.setPremiumAvailability(premiumAvailability-premiumSeatChoice);
		availableSeatRepository.save(dto1);
	}
	private void setAvailableSeat(AvailableSeatDto dto)
	{
		availableSeatRepository.save(dto);
	}

}
