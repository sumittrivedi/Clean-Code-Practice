package daoImpl;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import dao.ShowDetailsDao;
import dto.ShowDetailsDto;
import utilities.ConnectionFactory;

public class ShowDetailsDaoImpl implements ShowDetailsDao {
	
	private static final String GET_ShowId = "SELECT * FROM showdetails where theatreId =:theatreId and  date=:date and time=:time";

	@SuppressWarnings("unchecked")
	public int getShowId(int theatreId, String date, String time) {

		Query query = ConnectionFactory.getEntityManager().createNativeQuery(GET_ShowId, ShowDetailsDto.class);
		query.setParameter("theatreId", theatreId);
		query.setParameter("date", date);
		query.setParameter("time", time);
		
		ShowDetailsDto dto = new ShowDetailsDto();
		try {
			dto = (ShowDetailsDto) query.getResultList().stream().findFirst().orElse(null);
			if (dto == null) {
				ShowDetailsDto dto2 = new ShowDetailsDto();
				dto2.setTheatreId(theatreId);
				dto2.setDate(date);
				dto2.setTime(time);
				new ShowDetailsDaoImpl().setShowId(dto2);
			}
			Query query1 = ConnectionFactory.getEntityManager().createNativeQuery(GET_ShowId, ShowDetailsDto.class);
			query1.setParameter("theatreId", theatreId);
			query1.setParameter("date", date);
			query1.setParameter("time", time);
			dto = (ShowDetailsDto) query1.getSingleResult();

		} catch (NoResultException e) {
			e.printStackTrace();
		}
		return dto.getShowId();
	}

	private void setShowId(ShowDetailsDto showDetailsDto) {
		EntityManager em = ConnectionFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(showDetailsDto);
		em.getTransaction().commit();
	}

}
