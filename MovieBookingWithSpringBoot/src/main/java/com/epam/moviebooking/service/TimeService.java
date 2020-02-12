package com.epam.moviebooking.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.moviebooking.entity.TimeEntity;
import com.epam.moviebooking.repository.TimeRepository;

@Service
public class TimeService {
	
	@Autowired
	private TimeRepository timeRepository;
	@Autowired
	private Optional<TimeEntity> timeDtoOptional;
	@Autowired 
	private TimeEntity timeDto;
	
	public List<TimeEntity> getTime(LocalDate dateChoice)
	{
		List<TimeEntity> dummyTimeList = (List<TimeEntity>) timeRepository.findAll();
		List<TimeEntity> timeDtoList = (List<TimeEntity>) timeRepository.findAll();
		if (dateChoice.compareTo(LocalDate.now()) == 0)
			for (TimeEntity time : timeDtoList) 
			{
				int timeDifference = time.getTime().compareTo(LocalTime.now());
				if(timeDifference < 0)
					dummyTimeList.remove(time);
			}
			return dummyTimeList;
	}
	
	public List<TimeEntity> timeDetails()
	{
		return (List<TimeEntity>) timeRepository.findAll();
	}
	public void addTime(String time) 
	{
		LocalTime localTime = LocalTime.parse(time);
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
