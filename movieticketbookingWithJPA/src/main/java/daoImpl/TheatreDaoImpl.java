package daoImpl;
import java.util.List;
import javax.persistence.Query;
import dao.TheatreDao;
import dto.TheatreDto;
import utilities.ConnectionFactory;

public class TheatreDaoImpl implements TheatreDao {
	
	private static final String GET_TheatreId = "SELECT * from theatredetails where TheatreName= :TheatreName";
	private static final String GET_TheatreByChoice = "SELECT TheatreName from theatredetails where LocationID in (select LocationID from locationdetails where LocationName = :LocationName) and TheatreID in (select TheatreID from moviedetails where MovieName = :MovieName)";
	

	@Override
	public  int getTheatreId(String theatreName)
	{
		Query query = ConnectionFactory.getEntityManager().createNativeQuery(GET_TheatreId, TheatreDto.class);
		query.setParameter("TheatreName", theatreName);
		return ((TheatreDto)query.getSingleResult()).getTheatreId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> theatreByMovie(String locationChoice, String movieChoice) 
	{
		Query query = ConnectionFactory.getEntityManager().createNativeQuery(GET_TheatreByChoice);
		query.setParameter("LocationName", locationChoice);
		query.setParameter("MovieName", movieChoice);
		return query.getResultList();
	}

}
