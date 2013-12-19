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
import tp3.TypeSport;
import tp3.srv.TypeSportService;

@Path("/sport")
public class TypeSportServiceImpl implements TypeSportService {

	private EntityManager entityManager;
	
	
	public TypeSportServiceImpl() {
		entityManager = EntityMan.getInstance();
	}
	
	
	@PUT @Path("creer")
	public long creerTypeSport() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		TypeSport typeSport = new TypeSport();
		entityManager.persist(typeSport);
		
		transaction.commit();
		
		return typeSport.getId();
	}
	

	@GET @Path("afficher/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public TypeSport getTypeSport(@PathParam("id") long id) {
		Query query = entityManager.createQuery ("SELECT typesSport FROM TypeSport as typesSport where typesSport.id=:p_id");
		query.setParameter("p_id", id);
		
		return (TypeSport)query.getSingleResult();
	}

	
	@SuppressWarnings("unchecked")
	@GET @Path("afficher")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<TypeSport> getTypesSport() {
		Query query = entityManager.createQuery ("SELECT typesSport FROM TypeSport as typesSport");
		return query.getResultList();
	}

	
	@POST @Path("modifier/{id}/{nom}")
	public void modifier(@PathParam("id") long id, @PathParam("nom") String nom) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		TypeSport typeSport = getTypeSport(id);
		typeSport.setNom(nom);
		
		transaction.commit();
	}

	
	@DELETE @Path("supprimerSport/{id}")
	public void supprimerSport(@PathParam("id") long id) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		TypeSport typeSport = getTypeSport(id);
		entityManager.remove(typeSport);
		
		transaction.commit();
	}

	
}
