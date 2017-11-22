package tour.donnees.nuvem.controller;

import tour.donnees.nuvem.TesteHibernate;
import tour.donnees.nuvem.dao.AccountDAO;
import tour.donnees.nuvem.entity.Account;

public class AccountController {
	
	private AccountDAO dao;
	
	public AccountController() {
		this.dao = AccountDAO.getInstance(TesteHibernate.getSessionFactory().openSession());
	}
	
	public Account accountById(Long id){
		return dao.getById(id);
	}
	
	public Account insertAccount(Account account) {
		return dao.saveObject(account);
	}
	
	public Account updateAccount(Account account, Long id) {
		Account newAccount = dao.getById(id);
		
		newAccount.setPassword(account.getPassword());
		newAccount.getPerson()
			.setName(account.getPerson().getName());
		newAccount.getPerson().setLikes(account.getPerson().getLikes());
		
		return dao.updateObject(newAccount, id);
	}
	
	public Account deleteAccount(Long id) {
		return dao.deleteObject(id);
	}

}
