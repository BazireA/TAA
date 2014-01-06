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
			EntityManager entityManager = EntityMan.getInstance();

			
			TypeSportService typeSportService = new TypeSportServiceImpl();
			typeSportService.creerTypeSport();
			typeSportService.modifier(1, "Running");
			typeSportService.creerTypeSport();
			typeSportService.modifier(2, "Marche à pied");
			
			ListeChansonService playlistService = new ListeChansonServiceImpl();
			playlistService.creer("Playlist 1");
			playlistService.creer("Playlist 2");
			
			ParcoursService parcoursService = new ParcoursServiceImpl();
			parcoursService.creer("Parcours 1");
			parcoursService.creer("Parcours 2");
			
			
			// Begin a transaction
			EntityTransaction transaction = null;
			try {
				transaction = entityManager.getTransaction();
				transaction.begin();
				
				// Your entity becomes persistant
				// em.persist(t);
				
				transaction.commit(); //do the flush automatically
			}
			catch (RuntimeException e) {
				if (transaction != null && transaction.isActive())
					transaction.rollback();
				throw e; // or display error message
			}
			finally {
				entityManager.close();
			}
			
			emf.close(); // close at application end
		}
}
