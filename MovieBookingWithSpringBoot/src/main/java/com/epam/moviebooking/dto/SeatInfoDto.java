package com.epam.moviebooking.dto;

public class SeatInfoDto implements Comparable<SeatInfoDto>{
	
	String seatId;
	String seatCategory;
	Double cost;
	
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getSeatCategory() {
		return seatCategory;
	}
	public void setSeatCategory(String seatCategory) {
		this.seatCategory = seatCategory;
	}
	@Override
	public int compareTo(SeatInfoDto seatInfoDto) {
		
		return this.seatId.compareTo(seatInfoDto.seatId);
	}
	
	
}
