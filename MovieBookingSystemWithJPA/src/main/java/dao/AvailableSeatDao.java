package dao;

import dto.AvailableSeatDto;

public interface AvailableSeatDao {
	
	public void updateAvailableSeat(AvailableSeatDto dto, int premiumSeatChoice, int executiveSeatChoice);
	public void setAvailableSeat(int showId);
	public AvailableSeatDto getAvailableSeat(int showId);
	
}
