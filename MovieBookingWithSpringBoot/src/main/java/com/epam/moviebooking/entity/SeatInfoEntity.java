package com.epam.moviebooking.entity;

public class SeatInfoEntity implements Comparable<SeatInfoEntity>{
	
	private String seatId;
	private String seatCategory;
	private Double cost;
	
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
	public int compareTo(SeatInfoEntity seatInfoEntity) {
		return this.seatId.compareTo(seatInfoEntity.seatId);
	}
	
	
}
