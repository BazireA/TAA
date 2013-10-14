package tp3;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import tp3.srv.ChansonService;
import tp3.srv.ListeChansonService;
import tp3.srv.PersonService;
import tp3.srv.SeanceService;
import tp3.srv.impl.ChansonServiceImpl;
import tp3.srv.impl.ListeChansonServiceImpl;
import tp3.srv.impl.PersonServiceImpl;
import tp3.srv.impl.SeanceServiceImpl;

public class Main {

		public static void main(String[] args){
			// Use persistence.xml configuration
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");
			// Retrieve an entity manager
			EntityManager em = emf.createEntityManager();
			// Work with the EM
			// Can create entity
			
			
			PersonService ps = new PersonServiceImpl(em);
			ps.creerPersonne("nom", "prenom","email", "facebook");
			
			ListeChansonService lc = new ListeChansonServiceImpl(em);
			lc.creerListeChanson("liste01");
			
			ChansonService chanson = new ChansonServiceImpl(em);
			chanson.creerChanson("chanson01", 30);
			//lc.ajouterChanson("liste01", chanson.creerChanson("chanson01", 30));
			
			ChansonService chanson2 = new ChansonServiceImpl(em);
			chanson2.creerChanson("chanson02", 40);
			
			chanson2.supprimerChanson("chanson01");
			
			SeanceService s = new SeanceServiceImpl(em);
			s.creerSeance();
			s.definirListeChanson(0L, lc.getListeChanson("liste01"));
			s.definirMeteo(0,new Meteo());
			s.definirParcours(0,new Parcours());
			s.definirTypeDeSport(0,new TypeSport());
			
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
