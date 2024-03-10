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

// What's the different from @WebServlet("/updateFilm/{id}")
@WebServlet("/updateFilm")
public class UpdateFilmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		try {
			FilmDAO dao = new FilmDAO();
			Film film = dao.getFilmByID(Integer.parseInt(request.getParameter("id")));
			
			System.out.println("film: " + film.toString());
			request.setAttribute("film", film);
			RequestDispatcher rd = request.getRequestDispatcher("UpdateFilm.jsp");
			rd.include(request, response);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
}