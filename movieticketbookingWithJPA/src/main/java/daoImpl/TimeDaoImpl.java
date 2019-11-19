package daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.TimeDao;

public class TimeDaoImpl implements TimeDao {

	private static final String GET_Time = "select time from showtiming";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getTime() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlDB");
		EntityManager em = emf.createEntityManager();
		Query query = em.createNativeQuery(GET_Time);
		List<String> times =  query.getResultList();
		return times;
	}
}
