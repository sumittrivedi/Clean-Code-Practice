package com.epam.moviebooking.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.moviebooking.dto.TimeDto;
import com.epam.moviebooking.repository.TimeRepository;

@Service
public class TimeService {
	
	@Autowired
	TimeRepository timeRepository;
	
	public List<TimeDto> getTime(LocalDate dateChoice)
	{
		List<TimeDto> timeDtoList1 = (List<TimeDto>) timeRepository.findAll();
		List<TimeDto> timeDtoList = (List<TimeDto>) timeRepository.findAll();
		if (dateChoice.compareTo(LocalDate.now()) == 0)
			for (TimeDto timeDto : timeDtoList) 
			{
				if(timeDto.getTime().compareTo(LocalTime.now()) < 0)
				timeDtoList1.remove(timeDto);
			}
			return timeDtoList1;
	}
}
