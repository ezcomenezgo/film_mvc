package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.FilmDAO;

@WebServlet("/deleteFilm")
public class DeleteFilmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			FilmDAO dao = new FilmDAO();
			int id = Integer.parseInt(request.getParameter("id"));
			
			try {
				boolean result = dao.deleteFilmById(id);
				System.out.println("result" + result);
				
				if (result) {
					response.sendRedirect("/FilmMVC/films");
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}