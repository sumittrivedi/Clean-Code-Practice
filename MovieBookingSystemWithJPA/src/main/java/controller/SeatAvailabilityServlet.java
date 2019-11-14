package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.AvailableSeatDto;
import service.SeatAvailabilityService;
import service.ShowDetailsService;
import service.TheatreService;

public class SeatAvailabilityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String dateChoice = request.getParameter("dateChoice");
		String timeChoice = request.getParameter("timeChoice");
		
		HttpSession session = request.getSession();
		session.setAttribute("dateChoice", dateChoice);
		session.setAttribute("timeChoice", timeChoice);
	
		String theatreChoice =  (String) session.getAttribute("theatreChoice");
		
		TheatreService theatreService = new TheatreService();
		int theatreId = theatreService.getTheatreId(theatreChoice);
		
		ShowDetailsService sdService = new ShowDetailsService();
		int showId = sdService.getShowId(theatreId, dateChoice, timeChoice);
		
		SeatAvailabilityService saService = new SeatAvailabilityService();
		AvailableSeatDto availableSeatDto = saService.getAvailableSeat(showId);

		session.setAttribute("availableSeatDto", availableSeatDto);
		RequestDispatcher rd = request.getRequestDispatcher("seatAvailability.jsp");
		rd.forward(request, response);
	}
}
