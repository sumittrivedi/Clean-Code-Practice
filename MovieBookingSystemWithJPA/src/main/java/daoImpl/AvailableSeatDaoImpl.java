package daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import dao.AvailableSeatDao;
import dto.AvailableSeatDto;
import utilities.ConnectionFactory;

public class AvailableSeatDaoImpl implements AvailableSeatDao {

	public void updateAvailableSeat(AvailableSeatDto dto, int premiumSeatChoice, int executiveSeatChoice) {

		int showId = dto.getShowId();
		EntityManager em = ConnectionFactory.getEntityManager();
		em.getTransaction().begin();
		AvailableSeatDto availableSeatDto = em.find(AvailableSeatDto.class, showId);
		availableSeatDto.setExecutiveAvailabilty(availableSeatDto.getExecutiveAvailabilty()-executiveSeatChoice);
		availableSeatDto.setPremiumAvailability(availableSeatDto.getPremiumAvailability()-premiumSeatChoice);
		em.getTransaction().commit();
	}

	public void setAvailableSeat(int showId) {

		int premiumSeats = 20;
		int executiveSeats = 80;
		EntityManager em = ConnectionFactory.getEntityManager();
		em.getTransaction().begin();
		AvailableSeatDto availableSeatDto = new AvailableSeatDto();
		availableSeatDto.setShowId(showId);
		availableSeatDto.setPremiumAvailability(premiumSeats);
		availableSeatDto.setExecutiveAvailabilty(executiveSeats);
		em.persist(availableSeatDto);
		em.getTransaction().commit();
	}

	
	public AvailableSeatDto getAvailableSeat(int showId) {
		
		AvailableSeatDto availableSeatDto = ConnectionFactory.getEntityManager().find(AvailableSeatDto.class, showId);
		try
		{
			if(availableSeatDto == null)
				new AvailableSeatDaoImpl().setAvailableSeat(showId);			
			availableSeatDto = ConnectionFactory.getEntityManager().find(AvailableSeatDto.class, showId);
		}
		catch (NoResultException e) {
			e.printStackTrace();
		}
		return availableSeatDto;
	}

}
