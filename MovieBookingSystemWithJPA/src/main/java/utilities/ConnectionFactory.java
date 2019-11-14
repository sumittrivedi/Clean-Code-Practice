package utilities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

	private static EntityManager entityManager = null;

	private ConnectionFactory() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlDB");
		entityManager = emf.createEntityManager();
		
	}

	public static EntityManager getEntityManager() 
	{
		if (entityManager == null)
			new ConnectionFactory();
		return entityManager;
	}
}
