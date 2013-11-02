package tp3;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import tp3.srv.ChansonService;
import tp3.srv.ListeChansonService;
import tp3.srv.PersonService;
import tp3.srv.impl.ChansonServiceImpl;
import tp3.srv.impl.ListeChansonServiceImpl;
import tp3.srv.impl.PersonServiceImpl;

public class Main {

		public static void main(String[] args){
			// Use persistence.xml configuration
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");
//			EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-fouad");
			// Retrieve an entity manager
			EntityManager em = EntityMan.getInstance();
			// Work with the EM
			// Can create entity
			
			
			PersonService ps = new PersonServiceImpl();
			ps.creerPersonne("nom", "prenom","email", "facebook");
			
			ListeChansonService lc = new ListeChansonServiceImpl();
			lc.creerListeChanson("liste01");
			
			ChansonService chanson = new ChansonServiceImpl();
			chanson.creerChanson("chanson01", 30);
			//lc.ajouterChanson("liste01", chanson.creerChanson("chanson01", 30));
			
			ChansonService chanson2 = new ChansonServiceImpl();
			chanson2.creerChanson("chanson02", 40);
			
			chanson2.supprimerChanson("chanson01");
			
			
			//....
			// Begin a transaction
			EntityTransaction tx = null;
			try {
				tx = em.getTransaction();
				tx.begin();
				// Your entity becomes persistant
				// em.persist(t);
				tx.commit(); //do the flush automatically
			} catch (RuntimeException e) {
				if (tx != null && tx.isActive())
					tx.rollback();
				throw e; // or display error message
			} finally {
				em.close();
			}
			emf.close(); // close at application end
		}

}
