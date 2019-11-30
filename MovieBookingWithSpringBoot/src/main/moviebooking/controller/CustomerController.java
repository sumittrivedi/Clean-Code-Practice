package com.epam.moviebooking.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CustomerController {

	@RequestMapping("customer")
	public ModelAndView CustomerServlet()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customer");
		return mv;
	}
}
