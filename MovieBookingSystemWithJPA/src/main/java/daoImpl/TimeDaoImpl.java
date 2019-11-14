package daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.TimeDao;

public class TimeDaoImpl implements TimeDao {

	@SuppressWarnings("unchecked")
	public List<String> getTime() {
		
		String sqlQuery = "select time from showtiming";	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlDB");
		EntityManager em = emf.createEntityManager();
		Query query = em.createNativeQuery(sqlQuery);
		List<String> times =  query.getResultList();
		return times;
	}
}
