package util;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author  Vinicius Pedro da Silveira
 */

@ApplicationScoped
public class Application implements Serializable {

	private static final long serialVersionUID = -653769795684594996L;
	
	@PersistenceContext(unitName = "primary")
    private static EntityManager entityManager;
	
    public static EntityManager getEntityManager() {
    	return entityManager;
    }
    
}
