package tp3.srv.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tp3.Chanson;
import tp3.EntityMan;
import tp3.srv.ChansonService;

@Path("/chansons")
public class ChansonServiceImpl implements ChansonService {

	private EntityManager entityManager;
	
	
	public ChansonServiceImpl() {
		entityManager = EntityMan.getInstance();
	}
	

	/*public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}*/
	
	
	@PUT @Path("creer/{nom}/{duree}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Chanson creerChanson(@PathParam("nom") String nom, @PathParam("duree") int duree) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Chanson chanson = new Chanson();
		chanson.setNom(nom);
		chanson.setDuree(duree);
		entityManager.persist(chanson);
		
		transaction.commit();
		
		return chanson;
	}

	 @DELETE @Path("delete/{nom}")
	//    @Produces({ MediaType.APPLICATION_JSON })   
	public void supprimerChanson(@PathParam("nom")  String nom) {		
		Query query = entityManager.createQuery ("SELECT chansons FROM Chanson as chansons where chansons.nom=:p_nom");
		query.setParameter("p_nom", nom);
		
		@SuppressWarnings("unchecked")
		List<Chanson> results = query.getResultList();
		
		if(!results.isEmpty()) {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			
			entityManager.remove(results.get(0));
		
			transaction.commit();
		}
	}

}
