package com.epam.moviebooking.webservices.restclient;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerRestClient 
{
	RestTemplate restTemplate = new RestTemplate();
}
