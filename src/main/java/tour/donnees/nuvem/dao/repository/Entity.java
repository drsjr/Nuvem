package tour.donnees.nuvem.dao.repository;

import java.util.Collection;

public interface Entity<T>{
	
	Collection<T> getAll();
	
	T getById(Long id);
	
	T saveObject(T e);
	
	T updateObject(T e, Long id);
	
	T deleteObject(Long id);
	
}
