package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.FilmDAO;
import models.Film;

@WebServlet("/addFilm")
public class AddFilmController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("AddFilm.jsp");
		rd.include(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FilmDAO dao = new FilmDAO();
		Film film = new Film();
		
		film.setTitle(request.getParameter("title"));
		film.setYear(Integer.parseInt(request.getParameter("year")));
		film.setDirector(request.getParameter("director"));
		film.setStars(request.getParameter("stars"));
		film.setReview(request.getParameter("review"));
		
		try {
			boolean result = dao.insertFilm(film);
			System.out.println("result" + result);
			
			if (result) {
				response.sendRedirect("/FilmMVC/films");
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}