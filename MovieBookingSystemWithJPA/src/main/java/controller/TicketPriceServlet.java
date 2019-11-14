package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.AvailableSeatDto;
import service.SeatAvailabilityService;
import service.TicketPriceService;

public class TicketPriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int premiumSeatChoice = Integer.parseInt(request.getParameter("premiumSeatChoice"));
		int executiveSeatChoice = Integer.parseInt(request.getParameter("executiveSeatChoice"));
		
		HttpSession session = request.getSession();
		session.setAttribute("premiumSeatChoice", premiumSeatChoice);
		session.setAttribute("executiveSeatChoice", executiveSeatChoice);
		
		
		SeatAvailabilityService saService = new SeatAvailabilityService();
		saService.updateSeats((AvailableSeatDto) session.getAttribute("availableSeatDto"),premiumSeatChoice,executiveSeatChoice);
		
		TicketPriceService tpService = new TicketPriceService();
		Double ticketPrice = tpService.calculatePrice(premiumSeatChoice,executiveSeatChoice);
		session.setAttribute("ticketPrice", ticketPrice);
		
		RequestDispatcher rd = request.getRequestDispatcher("ticketPrice.jsp");
		rd.forward(request, response);
	}

}
