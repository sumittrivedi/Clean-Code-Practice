package com.epam.moviebooking.webservices.restcontroller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {

	@PostMapping("restCustomer")
	public String CustomerServlet()
	{
		return "Customer details entered";
	}
}
