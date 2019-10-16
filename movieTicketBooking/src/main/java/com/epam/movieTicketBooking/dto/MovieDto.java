package com.epam.movieTicketBooking.dto;

public class MovieDto {
	private String locationName;
	private String movieName;
	
	public MovieDto(String locationName, String movieName)
	{
		this.locationName = locationName;
		this.movieName = movieName;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	

}
