package dao;

import java.util.ArrayList;

import dto.TheatreDto;

public interface TheatreDao {
	
	public int getTheatreId(String theatreName);
	public ArrayList<TheatreDto> theatreByMovie(String locationChoice, String movieChoice);
}
