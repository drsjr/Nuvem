package tour.donnees.nuvem.dao.repository;

import java.util.List;

public interface AccountImpl<Account> {
	
	List<String> getLikes(Long id);

}
