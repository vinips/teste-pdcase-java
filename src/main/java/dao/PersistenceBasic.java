package dao;


import java.math.BigInteger;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import util.Application;
import util.Filter;


/**
 * @author  Vinicius Pedro da Silveira
 */

public abstract class PersistenceBasic <T> {
	
	@PersistenceContext(unitName = "primary")
    private static EntityManager entityManager;
	
	public static String DEFAULT_ORDER = "id";

	private Class<T> entityClass;
	
	private String defaultOrder;
		
	public abstract void inicialize();
	
    public int getCountModels() throws Exception {
    	int cont = getCountObjs();
        return cont;
    }
    
    @PostConstruct
    public void init() {
		entityManager = Application.getEntityManager();
    }
	
	public List<T> getObjs(Filter filter) throws Exception {
    	return findAllOrderedByNome(filter);
    }
	
	public int getCountObjs() throws Exception {
		verificaEntity();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = cb.createQuery(Long.class);
		criteria.select(cb.count(criteria.from(entityClass)));
		return entityManager.createQuery(criteria).getSingleResult().intValue();
    }
	
	public List<T> getObjs() throws Exception {
    	return findAllOrderedByNome(getDefaultOrder());
    }
    
	protected T find(Object arg1) throws Exception {
		verificaEntity();
        return (T) entityManager.find(entityClass, arg1);
    }
    
	public List<T> findAll() throws Exception  {
		verificaEntity();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteria = cb.createQuery(entityClass);
		criteria.select(criteria.from(entityClass));
        return entityManager.createQuery(criteria).getResultList();
    }
 
    public T findById(Long id) throws Exception {
    	verificaEntity();
    	return entityManager.find(entityClass, id);
    }
    
    public T findById(Class<T> entityClass, Long id) throws Exception {
    	verificaEntity();
    	return entityManager.find(entityClass, id);
    }
    
    public T findById(BigInteger id) throws Exception {
    	verificaEntity();
    	return entityManager.find(entityClass, id);
    }
    
	public List<T> findAllOrderedByNome(String column) throws Exception {
		verificaEntity();
    	CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    	CriteriaQuery<T> criteria = cb.createQuery(entityClass);
    	Root<T> entity = criteria.from(entityClass);
    	criteria.select(entity);
    	criteria.orderBy(cb.asc(entity.get(column)));
        return entityManager.createQuery(criteria).getResultList();
    }
	
	@SuppressWarnings("unchecked")
	public List<T> findAllOrderedByNome(Filter filter) throws Exception {	
		verificaEntity();
    	CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    	CriteriaQuery<T> criteria = cb.createQuery(entityClass);
    	Root<T> entity = criteria.from(entityClass);
    	criteria.select(entity);
    	if ( filter.isAscendant() && !filter.getPropertyOrder().isBlank() ) {
			criteria.orderBy(cb.asc(entity.get(filter.getPropertyOrder())));
		} else if ( !filter.getPropertyOrder().isBlank() ) {
			criteria.orderBy(cb.desc(entity.get(filter.getPropertyOrder())));
		}
    	Query query = entityManager.createQuery(criteria);  
    	
    	query.setFirstResult(filter.getFirstRecord());
    	query.setMaxResults(filter.getAmountRecords());
    	
    	return query.getResultList();
    }
	
	public List<T> findAllByColumn(String column, Object value) throws Exception {
		verificaEntity();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<T> criteria = cb.createQuery(entityClass);
	    Root<T> entity = criteria.from(entityClass);
	    criteria.select(entity).where(cb.equal(entity.get(column), value));
        return entityManager.createQuery(criteria).getResultList();
    }
	
	public List<T> findAllByColumnOrder(String column, Object value, String order) throws Exception {
		verificaEntity();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<T> criteria = cb.createQuery(entityClass);
	    Root<T> entity = criteria.from(entityClass);
	    criteria.select(entity).where(cb.equal(entity.get(column), value));
	    criteria.orderBy(cb.asc(entity.get(order)));
        return entityManager.createQuery(criteria).getResultList();
    }
	
	//busca por colunas com atributos em long
	public T findByColumn(String column, Long attribute, Class<T> classModel)   
	{
		if(attribute == null) return null;			
		entityClass = classModel;
		try
		{
	 	verificaEntity();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteria = cb.createQuery(entityClass);
        Root<T> entity = criteria.from(entityClass);
        criteria.select(entity).where(cb.equal(entity.get(column), attribute));        
        return entityManager.createQuery(criteria).getSingleResult();
		}
		catch (Exception e) 
		{
			return null;
		}
	}
    
    public T findByColumn(String column, String value) throws Exception {
    	verificaEntity();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteria = cb.createQuery(entityClass);
        Root<T> entity = criteria.from(entityClass);
        criteria.select(entity).where(cb.equal(entity.get(column), value));
        return entityManager.createQuery(criteria).getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
   public T findByColumn(String column, String value, Class<?> classEntity) throws Exception 
    {
       setEntityClass((Class<T>) classEntity);
   		verificaEntity();
       CriteriaBuilder cb = entityManager.getCriteriaBuilder();
       CriteriaQuery<T> criteria = cb.createQuery(entityClass);
       Root<T> entity = criteria.from(entityClass);
       criteria.select(entity).where(cb.equal(entity.get(column), value));
       return entityManager.createQuery(criteria).getSingleResult();
   }
 
    public void detach(Object arg1) throws Exception {
    	verificaEntity();
        entityManager.detach(arg1);
    }
    
    public Object merge(Object arg1) throws Exception {
    	verificaEntity();
        entityManager.merge(arg1);
        return arg1;
    }
    
    public void save(Object arg1) throws Exception { 
    	verificaEntity();
        entityManager.persist(arg1);
    }
    
    public void update(Object arg1) throws Exception {
    	verificaEntity();
        entityManager.merge(arg1);
        entityManager.flush();
    }
    
    public void deletar(Object arg1) throws Exception {
    	verificaEntity();
        arg1 = entityManager.merge(arg1);
        entityManager.remove(arg1);
        entityManager.flush();
    }
    
	public SQLQuery getSQLQuery(String sql) throws Exception {
		verificaEntity();
		Session session = (Session) entityManager.getDelegate();     
	    return session.createSQLQuery(sql);	
	}
    
    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

	public String getDefaultOrder() {
		if (this.defaultOrder.isBlank()) {
			defaultOrder = DEFAULT_ORDER;
		}
		return defaultOrder;
	}

	public void setDefaultOrder(String defaultOrder) {
		this.defaultOrder = defaultOrder;
	}
	
	private void verificaEntity() {
		if (entityManager == null) {
			entityManager = Application.getEntityManager();
		}
	}    
	
}