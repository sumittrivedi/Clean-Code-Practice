package daoImpl;
import java.util.List;
import javax.persistence.Query;

import dao.LocationDao;
import utilities.ConnectionFactory;

public class LocationDaoImpl implements LocationDao{
	
	String selectQuery = "select LocationName  from locationdetails";
	
	@SuppressWarnings("unchecked")
	public List<String> getLocation()
	{
		Query query = ConnectionFactory.getEntityManager().createNativeQuery(selectQuery);
		List<String> locations =  query.getResultList();
		return locations;
	}
	
}
