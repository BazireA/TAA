package tp3;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import tp3.srv.ListeChansonService;
import tp3.srv.ParcoursService;
import tp3.srv.TypeSportService;
import tp3.srv.impl.ListeChansonServiceImpl;
import tp3.srv.impl.ParcoursServiceImpl;
import tp3.srv.impl.TypeSportServiceImpl;

public class Main {

		public static void main(String[] args){
			// Use persistence.xml configuration
//			EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-fouad");
			
			// Retrieve an entity manager
			EntityManager em = EntityMan.getInstance();

			
			TypeSportService typeSport = new TypeSportServiceImpl();
			typeSport.creerTypeSport();
			typeSport.modifier(1, "Running");
			typeSport.creerTypeSport();
			typeSport.modifier(2, "Marche à pied");
			
			ListeChansonService playlist = new ListeChansonServiceImpl();
			playlist.creerListeChanson("Playlist 1");
			playlist.creerListeChanson("Playlist 2");
			
			ParcoursService parcours = new ParcoursServiceImpl();
			parcours.creerParcours("Parcours 1");
			parcours.creerParcours("Parcours 2");
			
			
			// Begin a transaction
			EntityTransaction tx = null;
			try {
				tx = em.getTransaction();
				tx.begin();
				
				// Your entity becomes persistant
				// em.persist(t);
				
				tx.commit(); //do the flush automatically
			}
			catch (RuntimeException e) {
				if (tx != null && tx.isActive())
					tx.rollback();
				throw e; // or display error message
			}
			finally {
				em.close();
			}
			emf.close(); // close at application end
		}
}
