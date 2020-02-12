package com.epam.moviebooking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "showdetails")
public class ShowDetailsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "showId")
	private int showId;
	
	@Column(name = "theatreId")
	private int theatreId;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "time")
	private String time;
	
	private String bookedSeats;
	

	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getBookedSeats() {
		return bookedSeats;
	}
	public void setBookedSeats(String bookedSeats) {
		this.bookedSeats = bookedSeats;
	}
}
