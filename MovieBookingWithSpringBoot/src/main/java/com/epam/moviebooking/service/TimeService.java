package com.epam.moviebooking.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.moviebooking.dto.TimeDto;
import com.epam.moviebooking.repository.TimeRepository;

@Service
public class TimeService {
	
	@Autowired
	private TimeRepository timeRepository;
	@Autowired
	private Optional<TimeDto> timeDtoOptional;
	@Autowired 
	private TimeDto timeDto;
	
	public List<TimeDto> getTime(LocalDate dateChoice)
	{
		List<TimeDto> timeDtoList1 = (List<TimeDto>) timeRepository.findAll();
		List<TimeDto> timeDtoList = (List<TimeDto>) timeRepository.findAll();
		if (dateChoice.compareTo(LocalDate.now()) == 0)
			for (TimeDto time : timeDtoList) 
			{
				int timeDifference = time.getTime().compareTo(LocalTime.now());
				if(timeDifference < 0)
					timeDtoList1.remove(time);
			}
			return timeDtoList1;
	}
	
	public List<TimeDto> timeDetails()
	{
		return (List<TimeDto>) timeRepository.findAll();
	}
	public void addTime(String time) throws NoSuchAlgorithmException
	{
		LocalTime localTime = LocalTime.parse(time);
		Random random = SecureRandom.getInstanceStrong();
		int timeId = random.nextInt();
		timeDto.setTimeId(timeId);
		timeDto.setTime(localTime);
		timeRepository.save(timeDto);
	}
	
	public void updateTime(int timeId, String time)
	{
		LocalTime localTime = LocalTime.parse(time);
		timeDtoOptional = timeRepository.findById(timeId);
		if(timeDtoOptional.isPresent())
			timeDto = timeDtoOptional.get();
		timeDto.setTime(localTime);
		timeRepository.save(timeDto);
	}
	public void deleteTime(int timeId)
	{
		timeDtoOptional = timeRepository.findById(timeId);
		if(timeDtoOptional.isPresent())
			timeDto = timeDtoOptional.get();
		timeRepository.delete(timeDto);
	}
}
