package tp3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityMan {

	private static volatile EntityManager instance = null;
		
	public EntityMan(){
		super();
	}
	
	public final static EntityManager getInstance() {
        //Le "Double-Checked Singleton"/"Singleton doublement vérifié" permet 
        //d'éviter un appel coûteux à synchronized, 
        //une fois que l'instanciation est faite.
        if (EntityMan.instance == null) {
           // Le mot-clé synchronized sur ce bloc empêche toute instanciation
           // multiple même par différents "threads".
           // Il est TRES important.
           synchronized(EntityMan.class) {
             if (EntityMan.instance == null) {
            	 
            	// Use persistence.xml configuration
//     			EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");
    			EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-fouad");
     			// Retrieve an entity manager
     			EntityManager em = emf.createEntityManager();
            	 
            	 EntityMan.instance = em;
             }
           }
        }
        return EntityMan.instance;
    }
}
