package tp3.srv.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tp3.EntityMan;
import tp3.ListeChanson;
import tp3.Meteo;
import tp3.Parcours;
import tp3.Seance;
import tp3.TypeSport;
import tp3.srv.SeanceService;

@Path("/seances")
public class SeanceServiceImpl implements SeanceService {

	private EntityManager entityManager;

	
	public SeanceServiceImpl() {
		entityManager = EntityMan.getInstance();
	}
	
	@GET @Path("afficher/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	private Seance getSeance(@PathParam("id") long id) {
		Query query = entityManager.createQuery ("SELECT seances FROM Seance as seances where seances.id=:p_id");
		query.setParameter("p_id", id);
		
		return (Seance)query.getSingleResult();
	}
	
	
	@PUT @Path("creer")
	public void creerSeance() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = new Seance();
		entityManager.persist(seance);
		
		transaction.commit();
	}

	
	@POST @Path("modifierDuree/{id}/{duree}")
	public void modifierDuree(@PathParam("id") long id, @PathParam("duree") int duree) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		seance.setDuree(duree);
		
		transaction.commit();
	}

	@POST @Path("modifierDistance/{id}/{distance}")
	public void modifierDistance(@PathParam("id") long id, @PathParam("distance") int distance) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		seance.setDistance(distance);
		
		transaction.commit();
	}

	@POST @Path("modifierVitesse/{id}/{distance}")
	public void modifierVitesse(@PathParam("id") long id, @PathParam("vitesse") int vitesse) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		seance.setVitesse(vitesse);
		
		transaction.commit();
	}

	@POST @Path("modifierVitesse/{id}/{calorie}")
	public void modifierCalorie(@PathParam("id") long id, @PathParam("calorie") int calorie) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		seance.setCalorie(calorie);
		
		transaction.commit();
	}

	@POST @Path("modifierRythmeCardiaque/{id}/{rythmeCardiaque}")
	public void modifierRythmeCardiaque(@PathParam("id") long id, @PathParam("rythmeCardiaque") int rythmeCardiaque) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		seance.setRythmeCardiaque(rythmeCardiaque);
		
		transaction.commit();
	}

	@POST @Path("modifierObjectif/{id}/{objectif}")
	public void modifierObjectif(@PathParam("id") long id, @PathParam("objectif") int objectif) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		seance.setObjectif(objectif);
		
		transaction.commit();
	}

	@POST @Path("modifierParcours/{id}/{parcours}")
	public void definirParcours(@PathParam("id") long id, @PathParam("parcours") Parcours parcours) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		seance.setParcours(parcours);
		
		transaction.commit();
	}

	@POST @Path("modifierListeChansons/{id}/{listeChansons}")
	public void definirListeChanson(@PathParam("id") long id, @PathParam("listeChanson") ListeChanson listeChansons) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		seance.setListeChanson(listeChansons);
		
		transaction.commit();
	}

	@POST @Path("modifierTypeDeSport/{id}/{typeSport}")
	public void definirTypeDeSport(@PathParam("id") long id, @PathParam("typeSport") TypeSport typeSport) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		seance.setTypeSport(typeSport);
		
		transaction.commit();
	}

	@POST @Path("modifierMeteo/{id}/{meteo}")
	public void definirMeteo(@PathParam("id") long id, @PathParam("meteo") Meteo meteo) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		seance.setMeteo(meteo);
		
		transaction.commit();
	}

	@POST @Path("modifierSeance/{id}")
	public void supprimerSeance(@PathParam("id") long id) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		entityManager.remove(seance);
		
		transaction.commit();
	}
}
