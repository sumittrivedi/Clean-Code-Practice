package daoImpl;
import java.util.List;
import javax.persistence.Query;
import dao.TheatreDao;
import dto.TheatreDto;
import utilities.ConnectionFactory;

public class TheatreDaoImpl implements TheatreDao {

	
	public  int getTheatreId(String theatreName)
	{
		String theatreIdQuery = "SELECT * from theatredetails where TheatreName='"+theatreName+"'";
		Query query = ConnectionFactory.getEntityManager().createNativeQuery(theatreIdQuery, TheatreDto.class);
		return ((TheatreDto)query.getSingleResult()).getTheatreId();
	}

	@SuppressWarnings("unchecked")
	public List<String> theatreByMovie(String locationChoice, String movieChoice) 
	{
		String theatreByChoice = "SELECT TheatreName from theatredetails where LocationID in"
				+ " (select LocationID from locationdetails where LocationName='" + locationChoice
				+ "') and TheatreID in " + "(select TheatreID from moviedetails where MovieName='" + movieChoice + "')";
		
		Query query = ConnectionFactory.getEntityManager().createNativeQuery(theatreByChoice);
		return query.getResultList();
	}

}
