package tour.donnees.nuvem.dao;

import org.hibernate.Session;

import tour.donnees.nuvem.dao.repository.MusicImpl;
import tour.donnees.nuvem.entity.Music;

public class MusicDAO extends GenericDAO<Music> implements MusicImpl<Music> {
	
	private static MusicDAO dao;
	
	private MusicDAO(Session session) {
		super(session, Music.class);
	}
	
	public static MusicDAO getInstance(Session session) {
		if(dao != null) {
			return dao;
		} else {
			dao = new MusicDAO(session);
		}
		return dao;
	}

}
