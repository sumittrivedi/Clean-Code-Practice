package dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "availableseatdetails")
public class AvailableSeatDto {
	
	@Id
	int showId;
	int premiumAvailability;
	int executiveAvailabilty;
	
//	@OneToOne
//	@MapsId
//	private ShowDetailsDto showDetailsDto;
	
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
