package dao;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import util.DaoUtil;

/**
 * @author Vinicius Pedro da Silveira
 */

public abstract class PersistenceBasic<E> {
	private EntityManager manager;

	@SuppressWarnings("rawtypes")
	private Class entityClass;

	@PostConstruct
	public void inicialize() {
		if (this.manager == null)
			this.manager = DaoUtil.getEntityManager();
	}

	public abstract void changeClass();

	public void setEntityClass(Class<?> entityClass) {
		this.entityClass = entityClass;
	}

	public SQLQuery getSQLQuery(String sql) throws Exception {
		Session session = (Session) manager.getDelegate();
		return session.createSQLQuery(sql);
	}

	@SuppressWarnings("unchecked")
	public E findById(String cpf) {
		try {
			Object user = manager.find(entityClass, cpf);
			return (E) user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public EntityManager getManager() {
		return manager;
	}

}