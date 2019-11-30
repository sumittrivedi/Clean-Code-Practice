package com.epam.moviebooking.restcontroller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epam.moviebooking.dto.TimeDto;
import com.epam.moviebooking.service.TimeService;

@RestController
public class TimeRestController {
	
	@Autowired
	private TimeService timeService;
	
	@GetMapping(value = "time")
	public List<TimeDto> TimeServlet(@RequestParam String dateChoice,HttpSession session)
	{
		LocalDate date = LocalDate.parse(dateChoice);
		session.setAttribute("dateChoice", dateChoice);
		List<TimeDto> timeList = timeService.getTime(date);
		return timeList;
	}

}
