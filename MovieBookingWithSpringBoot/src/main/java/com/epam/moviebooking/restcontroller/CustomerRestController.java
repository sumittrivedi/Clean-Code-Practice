package com.epam.moviebooking.restcontroller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {

	@PostMapping("customer")
	public String CustomerServlet()
	{
		return "Customer details entered";
	}
}
