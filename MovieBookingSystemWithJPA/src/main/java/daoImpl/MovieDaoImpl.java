package daoImpl;

import java.util.List;
import javax.persistence.Query;

import dao.MovieDao;
import utilities.ConnectionFactory;

public class MovieDaoImpl implements MovieDao {

	@SuppressWarnings("unchecked")
	public List<String> movieByLocation(String locationChoice)
	{
		String movieByLocation = "select distinct MovieName from moviedetails where moviedetails.TheatreID IN (select TheatreID from theatredetails where theatredetails.LocationId IN (select LocationId from locationdetails where locationdetails.LocationName='"+locationChoice+"'))";
		Query query = ConnectionFactory.getEntityManager().createNativeQuery(movieByLocation);
		return query.getResultList();
	}
}