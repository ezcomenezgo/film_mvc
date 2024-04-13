package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.FilmDAO;
import models.Film;

/**
 * Retrieve all Films
 */
@WebServlet("/films")
public class FilmsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FilmDAO dao = new FilmDAO();
		
		String title = request.getParameter("title");
		ArrayList<Film> films;

		if (title != null) {
			films = dao.getFilmByName(title);
		} else {
			films = dao.getAllFilms();
		}
		
		request.setAttribute("films", films);
		RequestDispatcher rd = request.getRequestDispatcher("Films.jsp");
		rd.include(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

}