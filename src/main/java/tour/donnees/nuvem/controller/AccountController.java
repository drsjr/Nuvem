package tour.donnees.nuvem.controller;

import java.util.List;

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
		return dao.updateObject(account, id);
	}
	
	public String deleteAccount(Long id) {
		dao.deleteObject(id);
		return "Deletado com sucesso";
	}
	
	public List<String> getLikesById(Long id) {
		return dao.getLikes(id);
	}
	

}
