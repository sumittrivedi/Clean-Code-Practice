package controller;

import java.io.IOException;
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
		
		int theatreId = new TheatreService().getTheatreId(theatreChoice);
		int showId = new ShowDetailsService().getShowId(theatreId, dateChoice, timeChoice);
		
		AvailableSeatDto availableSeatDto = new SeatAvailabilityService().getAvailableSeat(showId);

		session.setAttribute("availableSeatDto", availableSeatDto);
		request.getRequestDispatcher("seatAvailability.jsp").forward(request, response);
	}
}
