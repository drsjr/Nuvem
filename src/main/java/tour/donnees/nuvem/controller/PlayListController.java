package tour.donnees.nuvem.controller;

import java.util.List;

import org.hibernate.Session;

import tour.donnees.nuvem.TesteHibernate;
import tour.donnees.nuvem.dao.AccountDAO;
import tour.donnees.nuvem.dao.PlaylistDAO;
import tour.donnees.nuvem.entity.Account;
import tour.donnees.nuvem.entity.PlayList;

public class PlayListController {
	
	private PlaylistDAO dao;
	private AccountDAO accountDAO;
	
	public PlayListController() {
		Session session = TesteHibernate.getSessionFactory().openSession();
		this.accountDAO =  AccountDAO.getInstance(session);
		this.dao = PlaylistDAO.getInstance(session);
	}
	
	public PlayListController(Session session) {
		this.dao = PlaylistDAO.getInstance(session);
	}

	public PlayList getById(Long id) {
		return dao.getById(id);
	}
	
	public List<PlayList> getAllPlayList(Long id) {
		return dao.getAllPlaylist(id);
	}
	
	public PlayList newPlayList(Long accountId, PlayList playList) {
		Account account = accountDAO.getById(accountId);
		account.getPlaylist().add(playList);
		accountDAO.updateObject(account, accountId);
		return playList;
	}
	
}
