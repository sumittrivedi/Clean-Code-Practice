package daoImpl;

import javax.persistence.EntityManager;
import dao.TicketBookingDao;
import dto.TicketBookingDto;
import utilities.ConnectionFactory;

public class TicketBookingDaoImpl implements TicketBookingDao{
	
	@Override
	 public void setTicketBookingDetails(TicketBookingDto ticketBookingDto)
	 {
		 EntityManager em = ConnectionFactory.getEntityManager();
			em.getTransaction().begin();
			em.persist(ticketBookingDto);
			em.getTransaction().commit();
	 }
	
	@Override
	 public void getTicketBookingDetails(int bookingId)
	 {
		 EntityManager em = ConnectionFactory.getEntityManager();
			em.getTransaction().begin();
			TicketBookingDto ticketBookingDto = em.find(TicketBookingDto.class, bookingId);
			em.getTransaction().commit();
			ticketBookingDto.toString();
	 }
	 
	 
}
