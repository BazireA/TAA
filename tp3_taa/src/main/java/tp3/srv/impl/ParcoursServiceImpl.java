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

import tp3.EntityMan;
import tp3.Parcours;
import tp3.srv.ParcoursService;

@Path("/parcours")
public class ParcoursServiceImpl implements ParcoursService {

	private EntityManager entityManager;
	
	
	/******************************************************************\
	 * Constructeur
	\******************************************************************/
	public ParcoursServiceImpl() {
		entityManager = EntityMan.getInstance();
	}
	/******************************************************************/
	

	
	
	/******************************************************************\
	 * Create
	\******************************************************************/
	@PUT @Path("creer")
	public long creer(@PathParam("nom") String nom) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Parcours parcours = new Parcours();
		parcours.setNom(nom);
		
		entityManager.persist(parcours);
		
		transaction.commit();
		
		return parcours.getId();
	}
	/******************************************************************/

	
	
	
	/******************************************************************\
	 * Read
	\******************************************************************/
	@GET @Path("afficher/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Parcours getParcours(@PathParam("id") long id) {
		Query query = entityManager.createQuery ("SELECT parcours FROM Parcours as parcours where parcours.id=:p_id");
		query.setParameter("p_id", id);
		
		return (Parcours)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@GET @Path("afficher")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Parcours> getParcours() {
		Query query = entityManager.createQuery ("SELECT parcours FROM Parcours as parcours");
		
		return query.getResultList();
	}
	/******************************************************************/

	
	
	
	/******************************************************************\
	 * Update
	\******************************************************************/
	@POST @Path("modifier/{id}/{nom}")
	public void modifier(@PathParam("id") long id, @PathParam("nom") String nom) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Parcours parcours = getParcours(id);
		parcours.setNom(nom);
		
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
		
		Parcours parcours = getParcours(id);
		entityManager.remove(parcours);
		
		transaction.commit();
	}
	/******************************************************************/
}
