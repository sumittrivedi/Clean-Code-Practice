package daoImpl;

import javax.persistence.EntityManager;

import dao.TicketBookingDao;
import dto.TicketBookingDto;
import utilities.ConnectionFactory;

public class TicketBookingDaoImpl implements TicketBookingDao{
	
	public void setTicketBookingDetails(TicketBookingDto dto)
	{
		EntityManager em = ConnectionFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(dto);
		em.getTransaction().commit();
	}

}
