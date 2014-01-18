package tp3.srv.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tp3.Chanson;
import tp3.EntityMan;
import tp3.ListeChanson;
import tp3.srv.ChansonService;

@Path("/chansons")
public class ChansonServiceImpl implements ChansonService {

	private EntityManager entityManager;
	
	
	/******************************************************************\
	 * Constructeur
	\******************************************************************/
	public ChansonServiceImpl() {
		entityManager = EntityMan.getInstance();
	}
	/******************************************************************/
	
	
	
	
	/******************************************************************\
	 * Create
	\******************************************************************/
	@PUT @Path("creer/{nom}/{duree}")
	@Produces({ MediaType.APPLICATION_JSON })
	public long creerChanson(@PathParam("nom") String nom, @PathParam("duree") int duree) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Chanson chanson = new Chanson();
		chanson.setNom(nom);
		chanson.setDuree(duree);
		entityManager.persist(chanson);
		
		transaction.commit();
		
		return chanson.getId();
	}
	/******************************************************************/
	
	
	
	
	/******************************************************************\
	 * Read
	\******************************************************************/
	@GET @Path("afficher/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Chanson getChanson(@PathParam("id") long id) {
		Query query = entityManager.createQuery ("SELECT chansons FROM Chanson as chansons where chansons.id=:p_id");
		query.setParameter("p_id", id);
		
		return (Chanson)query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@GET @Path("afficher")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Chanson> getChansons() {
		Query query = entityManager.createQuery ("SELECT chansons FROM Chanson as chansons");
		
		return query.getResultList();
	}
	/******************************************************************/
	
	
	
	
	/******************************************************************\
	 * Update
	\******************************************************************/
	@POST @Path("modifier/{id}/{nom}/{duree}")
	public void modifier(@PathParam("id") long id, @PathParam("nom") String nom, @PathParam("duree") int duree) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Chanson chanson = getChanson(id);
		chanson.setNom(nom);
		chanson.setDuree(duree);
		
		transaction.commit();
	}
	/******************************************************************/

	
	
	
	/******************************************************************\
	 * Delete
	\******************************************************************/
	@DELETE @Path("supprimer/{id}")
	public void supprimerChanson(@PathParam("id") long id) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Chanson chanson = getChanson(id);
		
		for(ListeChanson playlist : chanson.getListeChanson()) {
			playlist.removeChanson(chanson);
		}
		
		entityManager.remove(chanson);
		
		transaction.commit();
	}
	/******************************************************************/
}
