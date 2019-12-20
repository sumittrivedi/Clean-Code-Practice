package com.epam.moviebooking.viewcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.moviebooking.dto.SeatArrangementDto;
import com.epam.moviebooking.dto.SeatInfoDto;
import com.epam.moviebooking.service.SeatArrangementService;
import com.epam.moviebooking.service.TheatreService;
import com.epam.moviebooking.webservices.restclient.SeatArrangementRestClient;

@Controller
public class SeatArrangementController {
	
	@Autowired
	private SeatArrangementRestClient seatArrangementRestClient;
	@Autowired
	private SeatArrangementService seatArrangementService;
	@Autowired
	private TheatreService theatreService;
	
	@GetMapping("seatArrangement")
	public ModelAndView seatAvailability(@RequestParam String timeChoice,HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		session.setAttribute("timeChoice", timeChoice);
		String dateChoice =  (String) session.getAttribute("dateChoice");
		String theatreChoice =  (String) session.getAttribute("theatreChoice");
//		ArrayList<HashMap<SeatArrangementDto, Boolean>> seatDetails= seatArrangementRestClient.seatDetails(theatreChoice,dateChoice,timeChoice);
		int theatreId = theatreService.getTheatreId(theatreChoice);
		SortedMap<SeatInfoDto, Boolean> seatDetails= seatArrangementService.getSeatDetails(theatreId, dateChoice,timeChoice);
		
		session.setAttribute("seatDetails", seatDetails);
		mv.setViewName("seatArrangement");
		return mv;
	}

}
