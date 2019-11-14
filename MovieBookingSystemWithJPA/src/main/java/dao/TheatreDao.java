package dao;

import java.util.List;

public interface TheatreDao {
	
	public int getTheatreId(String theatreName);
	public List<String> theatreByMovie(String locationChoice, String movieChoice);
}
