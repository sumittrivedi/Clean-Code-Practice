package com.epam.moviebooking.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.epam.moviebooking.dto.TimeDto;
import com.epam.moviebooking.service.DateTimeService;

@RestController
public class DateTimeController {
	
	@Autowired
	private DateTimeService dateTimeService;
	@RequestMapping("dateTime")
	public ModelAndView DateTimeServlet(@RequestParam String theatreChoice,HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		session.setAttribute("theatreChoice", theatreChoice);
		ArrayList<String> dateList = dateTimeService.getDate();
		mv.addObject("dateList", dateList);
		List<TimeDto> timeList = dateTimeService.getTime();
		mv.addObject("timeList", timeList);
		mv.setViewName("dateTime");
		return mv;
	}

}
