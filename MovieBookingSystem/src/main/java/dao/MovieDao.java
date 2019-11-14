package dao;

import java.util.ArrayList;

import dto.MovieDto;

public interface MovieDao {
	
	public ArrayList<MovieDto> movieByLocation(String locationChoice);
}
