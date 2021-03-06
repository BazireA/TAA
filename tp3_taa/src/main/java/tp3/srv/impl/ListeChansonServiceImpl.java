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
import tp3.srv.ListeChansonService;

@Path("/listechansons")
public class ListeChansonServiceImpl implements ListeChansonService {

	private EntityManager entityManager;

	
	/******************************************************************\
	 * Constructeur
	\******************************************************************/
	public ListeChansonServiceImpl() {
		entityManager = EntityMan.getInstance();
	}
	/******************************************************************/
	

	
	
	/******************************************************************\
	 * Create
	\******************************************************************/
	@PUT @Path("creer/{nom}")
	public long creer(@PathParam("nom") String nom) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		ListeChanson chanson = new ListeChanson(nom);
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
	public ListeChanson getListeChanson(@PathParam("id") long id){
		Query query = entityManager.createQuery ("SELECT listesChansons FROM ListeChanson as listesChansons where listesChansons.id=:p_id");
		query.setParameter("p_id", id);
		
		return (ListeChanson)query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@GET @Path("afficher")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<ListeChanson> getListesChanson() {
		Query query = entityManager.createQuery ("SELECT listesChansons FROM ListeChanson as listesChansons");
		
		return query.getResultList();
	}
	/******************************************************************/


	
	
	/******************************************************************\
	 * Update
	\******************************************************************/
	@POST @Path("modifier/{id}/{nouveauNom}")
	public void modifier(@PathParam("id") long id, @PathParam("nouveauNom") String nouveauNom) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		ListeChanson listeChanson = getListeChanson(id);
		listeChanson.setNom(nouveauNom);
		
		transaction.commit();
	}
	
	@POST @Path("ajouterChanson/{id}/{idChanson}")
	public void ajouterChanson(@PathParam("id") long id, @PathParam("idChanson") long idChanson) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		ChansonService chansonService = new ChansonServiceImpl();
		
		ListeChanson listeChanson = getListeChanson(id);
		Chanson chanson = chansonService.getChanson(idChanson);
		listeChanson.addChanson(chanson);
		
		transaction.commit();
	}

	@DELETE @Path("enleverChanson/{id}/{idChanson}")
	public void enleverChanson(@PathParam("id") long id, @PathParam("idChanson")long idChanson) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		ChansonService chansonService = new ChansonServiceImpl();
		
		ListeChanson listeChanson = getListeChanson(id);
		Chanson chanson = chansonService.getChanson(idChanson);
		listeChanson.removeChanson(chanson);
		
		transaction.commit();
	}
	/******************************************************************/

	
	

	/******************************************************************\
	 * Delete
	\******************************************************************/
	@DELETE @Path("supprimer/{id}")
	public void supprimer(@PathParam("id") long id) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		ListeChanson listeChanson = getListeChanson(id);
		entityManager.remove(listeChanson);
		
		transaction.commit();
	}
	/******************************************************************/
}
