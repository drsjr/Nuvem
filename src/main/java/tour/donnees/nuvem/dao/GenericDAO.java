package tour.donnees.nuvem.dao;


import java.util.Collection;

import org.hibernate.Session;

import tour.donnees.nuvem.dao.repository.Entity;

public abstract class GenericDAO<T> implements Entity<T> {
	
	
	private Session session;
	
	private Class<T> entity;

	public GenericDAO(Session session, Class<T> entity) {
		this.session = session;
		this.entity  = entity;
	}
	
	@Override
	public Collection<T> getAll() {
		// TODO Auto-generated method stub
		return null;
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
