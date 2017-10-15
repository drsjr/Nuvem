package tour.donnees.nuvem;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tour.donnees.nuvem.entity.Account;
import tour.donnees.nuvem.entity.Album;
import tour.donnees.nuvem.entity.Artist;
import tour.donnees.nuvem.entity.Person;

public class TesteHibernate {

	private static SessionFactory factory = buildSessionFactory();

	
	public static void main(String... args) throws IllegalStateException {
		
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
		
		Artist art = new Artist();
		art.setName("Metallica");
		
		
		Album ab1 = new Album();
		ab1.setTitle("Black Album");
		ab1.setArtist(art);
		
		art.getAlbum().add(ab1);
		
		session.save(art);
		
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
	
}
