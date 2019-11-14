package service;

public class TicketPriceService {
	
	public double calculatePrice(int premiumSeatChoice,int executiveSeatChoice)
	{
		return 150*premiumSeatChoice + 100*executiveSeatChoice ;
	}

}
