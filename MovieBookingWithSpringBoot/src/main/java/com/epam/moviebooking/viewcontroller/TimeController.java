package com.epam.moviebooking.viewcontroller;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.moviebooking.dto.TimeDto;
import com.epam.moviebooking.service.TimeService;
import com.epam.moviebooking.webservices.restclient.TimeRestClient;

@Controller
public class TimeController {
	
	@Autowired
	private TimeRestClient timeRestClient;
	@Autowired
	private TimeService timeService;
	@Autowired
	private AdminController adminController;
	
	@GetMapping(value = "time")
	public ModelAndView timeServlet(@RequestParam String dateChoice,HttpSession session)
	{
		LocalDate date = LocalDate.parse(dateChoice);
		ModelAndView mv = new ModelAndView();
		session.setAttribute("dateChoice", dateChoice);
		List<TimeDto> timeList = timeRestClient.getTime(date);
		mv.addObject("timeList", timeList);
		mv.setViewName("time");
		return mv;
	}
	
	@PostMapping(value = "addTime")
	public ModelAndView addTime(@RequestParam String time) throws NoSuchAlgorithmException
	{
		timeService.addTime(time);
		return adminController.timeDetails();
	}
	
	@PostMapping(value = "updateTime")
	public ModelAndView updateTime(@RequestParam int timeId, @RequestParam String time)
	{
		timeService.updateTime(timeId,time);
		return adminController.timeDetails();
	}
	
	@PostMapping(value = "deleteTime")
	public ModelAndView deleteTime(@RequestParam int timeId)
	{
		timeService.deleteTime(timeId);
		return adminController.timeDetails();
	}

}
