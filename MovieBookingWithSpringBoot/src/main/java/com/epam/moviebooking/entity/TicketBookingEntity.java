package com.epam.moviebooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "ticketbookingdetails")
public class TicketBookingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	private String locationName;
	private double price;
	private String movieName;
	private String theatreName;
	private String date;
	private String time;
	private String seatIds;
	private String customerName;
	private String mobileNo;
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
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
	public String getSeatIds() {
		return seatIds;
	}
	public void setSeatIds(String seatIds) {
		this.seatIds = seatIds;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "TicketBookingDto [bookingId=" + bookingId + ", locationName=" + locationName + ", price=" + price
				+ ", movieName=" + movieName + ", theatreName=" + theatreName + ", date=" + date + ", time=" + time
				+ ", seatIds=" + seatIds + ", customerName=" + customerName + ", mobileNo=" + mobileNo + "]";
	}
}
