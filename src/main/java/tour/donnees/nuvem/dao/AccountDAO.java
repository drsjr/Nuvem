package tour.donnees.nuvem.dao;

import java.util.List;

import org.hibernate.Session;

import tour.donnees.nuvem.dao.repository.AccountImpl;
import tour.donnees.nuvem.dao.repository.Entity;
import tour.donnees.nuvem.entity.Account;

public class AccountDAO extends GenericDAO<Account> 
	implements AccountImpl<Account>, Entity<Account> {
	
	private static AccountDAO dao;

	private AccountDAO(Session session) {
		super(session, Account.class);
		// TODO Auto-generated constructor stub
	}
	
	public static AccountDAO getInstance(Session session) {
		if(dao != null){
			return dao;
		} else {
			dao = new AccountDAO(session);
		}
		return dao;
	}

	@Override
	public List<String> getLikes(Long id) {
		Account acc = this.getById(id);
		return acc.getPerson().getLikes();
	}

}
