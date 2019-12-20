package com.epam.moviebooking.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seatrowdetails")
public class SeatArrangementDto implements Comparable<SeatArrangementDto>{
	
	@Id
	String rowId;
	int numberOfSeats;
	String seatCategory;
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public String getSeatCategory() {
		return seatCategory;
	}
	public void setSeatCategory(String seatCategory) {
		this.seatCategory = seatCategory;
	}
	@Override
	public int compareTo(SeatArrangementDto o) {
		return this.rowId.compareTo(o.rowId);
	}
	
}
