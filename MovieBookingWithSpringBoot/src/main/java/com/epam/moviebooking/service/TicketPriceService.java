package com.epam.moviebooking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.epam.moviebooking.dto.SeatInfoDto;

@Service
public class TicketPriceService {
	
	public double calculatePrice(List<SeatInfoDto> seatInfos)
	{
		double totalTicketCost = 0.00;
		System.out.println("Inside TicketPriceService"+seatInfos);
		
		for (SeatInfoDto seatInfoDto : seatInfos) 
		{
			totalTicketCost += seatInfoDto.getCost();
			System.out.println("Inside forloop TicketPriceService"+totalTicketCost);
			
		}
			
		return totalTicketCost;
	}

}
