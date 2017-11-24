package tour.donnees.nuvem.dao;

import org.hibernate.Session;

import tour.donnees.nuvem.dao.repository.AccountImpl;
import tour.donnees.nuvem.entity.Account;

public class AccountDAO extends GenericDAO<Account> implements AccountImpl<Account>{
	
	private static AccountDAO dao;

	private AccountDAO(Session session) {
		super(session, Account.class);
	}
	
	public static AccountDAO getInstance(Session session) {
		if(dao != null){
			return dao;
		} else {
			dao = new AccountDAO(session);
		}
		return dao;
	}
}
