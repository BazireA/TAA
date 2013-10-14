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
import tp3.srv.ListeChansonService;

@Path("/listechansons")
public class ListeChansonServiceImpl implements ListeChansonService {

	private EntityManager entityManager;

	
	public ListeChansonServiceImpl() {
		entityManager = EntityMan.getInstance();
	}

	/*public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}*/

	
	@GET @Path("afficher/{nomListe}")
	@Produces({ MediaType.APPLICATION_JSON })
	public ListeChanson getListeChanson(@PathParam("nomListe") String nomListe){
		Query query = entityManager.createQuery ("SELECT listesChansons FROM ListeChanson as listesChansons where listesChansons.nom=:p_nomListe");
		query.setParameter("p_nomListe", nomListe);
		
		@SuppressWarnings("unchecked")
		List<ListeChanson> results = query.getResultList();
		
		if(!results.isEmpty())
			return results.get(0);
		else
			return null;
	}
	
	
	@PUT @Path("creer/{nom}")
	public void creerListeChanson(@PathParam("nom") String nom) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		ListeChanson chanson = new ListeChanson(nom);
		entityManager.persist(chanson);
		
		transaction.commit();
	}

	
	@POST @Path("modifier/{nomListe}/{nouveauNom}")
	public void modifierNomListe(@PathParam("nomListe") String nomListe,@PathParam("nouveauNom") String nouveauNom) {
		ListeChanson listeChanson = getListeChanson(nomListe);

		if(listeChanson != null){
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			
			listeChanson.setNom(nouveauNom);
			
			transaction.commit();
		}
	}

	@DELETE @Path("delete/{nomListe}/{chanson}")
	public void supprimerChanson(@PathParam("nomListe") String nomListe,@PathParam("chanson") Chanson chanson) {
		ListeChanson listeChanson = getListeChanson(nomListe);

		if(listeChanson != null){
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			
			listeChanson.removeChanson(chanson);
			
			transaction.commit();
		}
	}
	
	@POST @Path("ajouter/{nomListe}/{chanson}")
	public void ajouterChanson(@PathParam("nomListe") String nomListe,@PathParam("chanson") Chanson chanson) {		
		ListeChanson listeChanson = getListeChanson(nomListe);

		if(listeChanson != null) {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			
			listeChanson.addChanson(chanson);
			
			transaction.commit();
		}
	}
}
