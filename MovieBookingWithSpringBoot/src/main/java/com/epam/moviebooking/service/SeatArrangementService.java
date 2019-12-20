package com.epam.moviebooking.service;

import java.util.List;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.moviebooking.dto.SeatArrangementDto;
import com.epam.moviebooking.dto.SeatInfoDto;
import com.epam.moviebooking.repository.SeatArrangementRepository;
import com.epam.moviebooking.repository.TickettypeDetailsRepository;

@Service
public class SeatArrangementService {

	@Autowired
	private SeatArrangementRepository seatArrangementRepository;
	@Autowired
	private ShowDetailsService showDetailsService;
	@Autowired
	private TickettypeDetailsRepository tickettypeDetailsRepository;

	public SortedMap<SeatInfoDto, Boolean> getSeatDetails(int theatreId, String date, String time) {

		List<SeatArrangementDto> arr = (List<SeatArrangementDto>) seatArrangementRepository.findAll();
		SortedMap<SeatInfoDto, Boolean> seatDetails = new TreeMap<>();
		String bookedSeats = showDetailsService.getBookedSeats(theatreId, date, time);
		Optional<String> bookedSeatsOptional = Optional.ofNullable(bookedSeats);

		for (SeatArrangementDto seatArrangementDto : arr)
		{
			Double seatRowCost = tickettypeDetailsRepository.getSeatCost(seatArrangementDto.getRowId());
			
			for (int i = 0; i < seatArrangementDto.getNumberOfSeats(); i++) 
			{
				SeatInfoDto seatInfoDto = new SeatInfoDto();
				seatInfoDto.setSeatId(seatArrangementDto.getRowId().concat(String.valueOf(i)));
				seatInfoDto.setSeatCategory(seatArrangementDto.getSeatCategory());
				seatInfoDto.setCost(seatRowCost);
				if(bookedSeatsOptional.isPresent() && bookedSeats.contains(seatArrangementDto.getRowId().concat(String.valueOf(i))))
					seatDetails.put(seatInfoDto, true);
				else
					seatDetails.put(seatInfoDto, false);
			}
		}
		return seatDetails;
	}
}
