package tour.donnees.nuvem;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tour.donnees.nuvem.entity.Account;
import tour.donnees.nuvem.entity.Album;
import tour.donnees.nuvem.entity.Music;
import tour.donnees.nuvem.entity.Person;
import tour.donnees.nuvem.entity.PlayList;

public class TesteHibernate {

	private static SessionFactory factory = buildSessionFactory();

	
	public static void main(String... args) throws IllegalStateException, NumberFormatException {
		
		TesteHibernate teste = new TesteHibernate();
		
		Session session = getSessionFactory().openSession();
		
//		session.beginTransaction();
		
		/*Person p = new Person();
		
		p.setName("Mateus");
		p.setSex('M');
		p.setBirthDay(new Date());
		p.getLikes().add("Rock");
		p.getLikes().add("Indie");
		p.getLikes().add("Folk");
		
		Account a = new Account();
		a.setEmail("drsjr@servicemusic.com");
		a.setLogin("drsjr");
		a.setPassword("123456");
		a.setStatus(true);
		a.setPerson(p);
		
		session.save(a);*/
		
//		Account account = session.get(Account.class, 1L);
//		  
//		System.out.println("Name: " + account.getPerson().getName() + " Login: " + account.getLogin());
		
		
		session.beginTransaction();
		
		
//		Artist art = new Artist();
//		art.setName("Metallica");
//		Album ab1 = new Album();
//		ab1.setTitle("Black Album");
//		ab1.setArtist(art);
//		art.getAlbum().add(ab1);
//		session.save(art);
		
		Album BlackAlbum = (Album) session.get(Album.class, 2L);
		
//		Long l = new Long("10");
//		
//		Music music = new Music();
//		
//		music.setTitle("Fade to Black");
//		music.setDuration(l);
//		music.setGenre("Metal");
//		music.setSize(l);
//		music.setYear(1980);
//		music.setAlbum(BlackAlbum);
//		
//		
//		
		
		Account account = session.get(Account.class, 1L);
		Music music = session.get(Music.class, 2L);

//		PlayList play = new PlayList();
//		play.setName("Sometime");
//		
//		account.getPlaylist().add(play);
		account.getPlaylist().get(0).getMusics().add(music);
		
		
		session.save(account);
		
		session.getTransaction().commit();


	}

	public static SessionFactory buildSessionFactory() {

		try {
			Configuration cfg = new Configuration();
			cfg.configure();
			SessionFactory sf = cfg.buildSessionFactory();
			return sf;

		} catch (HibernateException e) {
			throw e;
		}
	}

	public static SessionFactory getSessionFactory() {
		return factory;
	}
	
	public Account testAccount() {
		
		Account ac = new Account();
		Person pr = new Person();
		
//		pr.setName("Djalma Junior");
//		pr.setBirthDay(new Date());
//		pr.setSex(new Character('M'));
		
		ac.setEmail("drsjr@musicservice.com");
		ac.setLogin("drsjr");
		ac.setPassword("123456");
		ac.setStatus(true);
		
		return ac;
		
	}
	
	public static Music autoMusic(Music music) {
		
		
		music.setTitle("Fade to Black");
		music.setDuration(new Long("2345.7463"));
		music.setGenre("Metal");
		music.setSize(new Long("200000"));
		music.setYear(1980);
		
		return music;
		
	}
	
}
