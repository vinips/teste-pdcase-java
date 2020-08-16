package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Vinicius Pedro da Silveira
 */

public class DaoUtil {
	
	private static EntityManagerFactory factory;

	static {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("pdcase");
		}
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}