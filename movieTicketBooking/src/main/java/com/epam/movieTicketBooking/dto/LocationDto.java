package com.epam.movieTicketBooking.dto;

public class LocationDto {
	private String locationName;
	
	public LocationDto(String locationName)
	{
		this.locationName = locationName;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	

}
