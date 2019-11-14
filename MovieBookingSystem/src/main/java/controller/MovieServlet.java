package controller;

import service.MovieService;
import dto.MovieDto;
import java.util.ArrayList;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MovieServlet
 */
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String locationChoice = request.getParameter("locationChoice");
		HttpSession session = request.getSession();
		session.setAttribute("locationChoice", locationChoice);
		ArrayList<MovieDto> movieList = new MovieService().movieByLocation(locationChoice);
		request.setAttribute("movieList", movieList);
		RequestDispatcher rd = request.getRequestDispatcher("movie.jsp");
		rd.forward(request, response);
	}

}