package tour.donnees.nuvem.dao;

import java.util.List;

import org.hibernate.Session;

import tour.donnees.nuvem.dao.repository.Entity;
import tour.donnees.nuvem.dao.repository.PlayListImpl;
import tour.donnees.nuvem.entity.Account;
import tour.donnees.nuvem.entity.PlayList;

public class PlaylistDAO extends GenericDAO<PlayList> 
	implements Entity<PlayList>, PlayListImpl<PlayList> {

	private static PlaylistDAO dao;
	
	private PlaylistDAO(Session session) {
		super(session, PlayList.class);
	}
	
	public static PlaylistDAO getInstance(Session session) {
		if(dao != null){
			return dao;
		} else {
			dao = new PlaylistDAO(session);
		}
		return dao;
	}

	@Override
	public List<PlayList> getAllPlaylist(Long accountId) {
		Account account = dao.getSession().get(Account.class, accountId);
		List<PlayList> lists = account.getPlaylist();
		return lists;
	}
	
}
