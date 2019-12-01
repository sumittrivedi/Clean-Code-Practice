package com.epam.moviebooking.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "theatredetails")
public class TheatreDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TheatreID")
	private int theatreId;
	
	@Column(name = "LocationID")
	private int locationId;
	
	@Column(name = "TheatreName")
	private String theatreName;
	
	

	public TheatreDto() {
		super();
	}
	
	public TheatreDto(int theatreId, int locationId, String theatreName) {
		super();
		this.theatreId = theatreId;
		this.locationId = locationId;
		this.theatreName = theatreName;
	}

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	

}
