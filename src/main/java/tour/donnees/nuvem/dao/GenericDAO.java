package tour.donnees.nuvem.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import tour.donnees.nuvem.dao.repository.Entity;

public abstract class GenericDAO<T> implements Entity<T> {
	
	
	private Session session;
	
	private Class<T> entity;

	public GenericDAO(Session session, Class<T> entity) {
		this.session = session;
		this.entity  = entity;
	}
	
	@Override
	public List<T> getAll() {
		@SuppressWarnings("unchecked")
		Query<T> query = getSession().createQuery("select t from " + entity.getSimpleName() + " t");
		return query.list();
	}

	@Override
	public T getById(Long id) {
		T e = getSession().get(getEntity(), id);
		return e;
	}

	@Override
	public T saveObject(T e) {
		getSession().save(e);
		getSession().persist(e);
		return e;
	}

	@Override
	public T updateObject(T e, Long id) {
		getSession().beginTransaction();
		getSession().saveOrUpdate(e);
		getSession().getTransaction().commit();
		return e;
	}
	@Override
	public T deleteObject(Long id) {
		T e = getSession().get(getEntity(), id);
		getSession().beginTransaction();
		getSession().delete(e);;
		getSession().getTransaction().commit();
		return e;
	}
	
	/**
	 * Get 
	 */
	protected Session getSession() {
		return session;
	}

	protected Class<T> getEntity() {
		return entity;
	}

}
