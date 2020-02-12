package com.epam.moviebooking.viewcontroller;

import java.util.SortedMap;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.moviebooking.entity.SeatInfoEntity;
import com.epam.moviebooking.service.SeatArrangementService;
import com.epam.moviebooking.service.TheatreService;

@Controller
public class SeatArrangementController {
	
	@Autowired
	private SeatArrangementService seatArrangementService;
	@Autowired
	private TheatreService theatreService;
	
	@GetMapping(value = "seatArrangement")
	public ModelAndView seatArrangement(@RequestParam String timeChoice,HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		session.setAttribute("timeChoice", timeChoice);
		String dateChoice =  (String) session.getAttribute("dateChoice");
		String theatreChoice =  (String) session.getAttribute("theatreChoice");
		int theatreId = theatreService.getTheatreId(theatreChoice);
		SortedMap<SeatInfoEntity, Boolean> seatDetails= seatArrangementService.getSeatDetails(theatreId, dateChoice,timeChoice);
		session.setAttribute("seatDetails", seatDetails);
		mv.setViewName("seatArrangement");
		return mv;
	}

}
