package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Film;

import java.sql.*;


public class FilmDAO {
	
	Connection c = null;
    Statement s = null;
	String user = "lijiawen";
    String password = "dreswAlt4";
    // Note none default port used, 6306 not 3306
    String url = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:6306/"+user;

	public FilmDAO() {}

	
	private Statement openConnection(){
		// loading jdbc driver for mysql
		try{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch(Exception e) { System.out.println(e); }

		// connecting to database
		try{
			// connection string for demos database, username demos, password demos
 			c = DriverManager.getConnection(url, user, password);
		    s = c.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return s;
    }

	private void closeConnection(){
		try {
			if (s != null) {
				s.close();
			}
			if (c != null) {
				c.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Film mapFilm(ResultSet rs){
    	Film thisFilm=null;
		try {
			thisFilm = new Film(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getInt("year"),
					rs.getString("director"),
					rs.getString("stars"),
					rs.getString("review"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return thisFilm;		
	}

	/**
	 * Retrieve all Films
	 * @return Collection of all films found in the mysql database
	 */
   public ArrayList<Film> getAllFilms(){
	   
		ArrayList<Film> allFilms = new ArrayList<Film>();
		openConnection();
		
	    // Create select statement and execute it
		try{
		    String selectSQL = "SELECT * FROM films";
		    ResultSet rs1 = s.executeQuery(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	Film oneFilm = mapFilm(rs1);
		    	allFilms.add(oneFilm);
		   }

		    s.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return allFilms;
   }

   /**
	 * Retrieve the Film by film ID
	 * @return The film from all films found in the mysql database
	 */
   public Film getFilmByID(int id){
	   
		openConnection();
		Film oneFilm = null;
	    // Create select statement and execute it
		try{
		    String selectSQL = "SELECT * FROM films WHERE id="+id;
		    ResultSet rs1 = s.executeQuery(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	oneFilm = mapFilm(rs1);
		    }

		    s.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return oneFilm;
   }
   
   /**
	 * Retrieve the Films by film name
	 * @return Collection from films contain keywords found in the mysql database
	 */
   public ArrayList<Film> getFilmByName(String name){
	   
		openConnection();
		ArrayList<Film> films = new ArrayList<Film>();
	    // Create select statement and execute it
		try{
		    String selectSQL = "SELECT * FROM films WHERE title LIKE '%"+ name + "%'";
		    ResultSet rs1 = s.executeQuery(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	Film oneFilm = mapFilm(rs1);
		    	films.add(oneFilm);
		   }

		    s.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return films;
  }
   
   /**
	 * Insert a new Film
	 * @return Boolean
	 */
   public boolean insertFilm(Film f) throws SQLException {
	   boolean b = false;
	   try {
		   String sql = "INSERT INTO films (title, year, director, stars, review) VALUES ("
		   		+ "'" + f.getTitle() + "','" 
				+ f.getYear() + "','" 
				+ f.getDirector() + "','" 
				+ f.getStars() + "','" 
				+ f.getReview()
				+ "');";
		   
		   System.out.println(sql);
		   b = openConnection().execute(sql);
		   closeConnection();
		   b = true;
	   } catch (SQLException s) {
		   throw new SQLException("Film Not Added");
	   }
	   
	   return b;
   }
   
   /**
	 * Update a Film
	 * @return Boolean
	 */
   public boolean updateFilm(Film f) throws SQLException {
	   boolean b = false;
	   try {
		   String sql = 
				   "UPDATE films SET title = '" + f.getTitle() + "',"
				   + " year = " +  f.getYear() + ","
				   + " director = '" +  f.getDirector() + "',"
				   + " stars = '" +  f.getStars() + "',"
				   + " review = '" +  f.getReview() + "'"
				   + " WHERE id = " + f.getId();
		   
		   System.out.println(sql);
		   b = openConnection().execute(sql);
		   closeConnection();
		   b = true;
	   } catch (SQLException e) {
		   throw new SQLException("Film Not Updated");
	   }
	   
	   return b;
   }
   
   /**
	 * Delete a Film by ID
	 * @return Boolean
	 */
   public boolean deleteFilmById(int id) throws SQLException {
	   boolean b = false;
	   try {
		   String sql = "DELETE FROM films WHERE id="+id;
		   
		   System.out.println(sql);
		   b = openConnection().execute(sql);
		   closeConnection();
		   b = true;
	   } catch (SQLException e) {
		   throw new SQLException("Film Not Deleted");
	   }
	   
	   return b;
   }
   
}
