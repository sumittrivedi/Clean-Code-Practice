package com.epam.moviebooking.viewcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.moviebooking.service.UserService;

@Controller
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "registration")
	public String registration()
	{
		return "registration";
	}

	@PostMapping(value = "addUser")
	public String addUser(@RequestParam String username, @RequestParam String password)
	{
		userService.addUser(username, password);
		return "login";
	}
}
