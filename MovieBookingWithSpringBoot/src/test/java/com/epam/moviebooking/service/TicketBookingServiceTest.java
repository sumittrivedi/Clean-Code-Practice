package com.epam.moviebooking.service;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
class TicketBookingServiceTest {

	
	@Test
	void calculatePrice() {
		
		assertEquals(450.00,new TicketPriceService().calculatePrice("A1 250.00,B3 200.00"));

	}

}
