package com.epam.moviebooking.daoImpl;

import javax.persistence.EntityManager;

import com.epam.moviebooking.dao.TicketBookingDao;
import com.epam.moviebooking.dto.TicketBookingDto;
import com.epam.moviebooking.utilities.ConnectionFactory;

public class TicketBookingDaoImpl implements TicketBookingDao{
	
	public void setTicketBookingDetails(TicketBookingDto dto)
	{
		EntityManager em = ConnectionFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(dto);
		em.getTransaction().commit();
	}

}
