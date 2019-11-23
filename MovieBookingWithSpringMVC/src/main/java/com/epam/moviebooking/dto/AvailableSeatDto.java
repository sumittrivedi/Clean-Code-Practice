package com.epam.moviebooking.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "availableseatdetails")
public class AvailableSeatDto {
	
	@Id
	int showId;
	int premiumAvailability;
	int executiveAvailabilty;
	
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public int getPremiumAvailability() {
		return premiumAvailability;
	}
	public void setPremiumAvailability(int premiumAvailability) {
		this.premiumAvailability = premiumAvailability;
	}
	public int getExecutiveAvailabilty() {
		return executiveAvailabilty;
	}
	public void setExecutiveAvailabilty(int executiveAvailabilty) {
		this.executiveAvailabilty = executiveAvailabilty;
	}
	
	

}
