package tour.donnees.nuvem.controller;

import tour.donnees.nuvem.TesteHibernate;
import tour.donnees.nuvem.dao.MusicDAO;

public class MusicController {
	
	private MusicDAO dao;
	
	public MusicController() {
		this.dao = MusicDAO.getInstance(TesteHibernate.getSessionFactory().openSession());
	}

}
