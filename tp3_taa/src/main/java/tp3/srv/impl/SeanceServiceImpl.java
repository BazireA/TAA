package tp3.srv.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

	
	/******************************************************************\
	 * Constructeur
	\******************************************************************/
	public SeanceServiceImpl() {
		entityManager = EntityMan.getInstance();
	}
	/******************************************************************/
	
	
	
	
	/******************************************************************\
	 * Create
	\******************************************************************/
	@PUT @Path("creer")
	public long creer() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = new Seance();
		entityManager.persist(seance);
		
		transaction.commit();
		
		return seance.getId();

	}
	
	@PUT @Path("creer/{distance}/{duree}/{vitesse}/{rythmeCardiaque}/{calorie}/{sport}/{playlist}/{meteo}/{parcours}")
	public long creer(	@PathParam("distance") int distance,
						@PathParam("duree") int duree,
						@PathParam("vitesse") int vitesse,
						@PathParam("rythmeCardiaque") int rythmeCardiaque,
						@PathParam("calorie") int calorie,
						@PathParam("sport") int sport,
						@PathParam("playlist") int playlist,
						@PathParam("meteo") String meteo,
						@PathParam("parcours") int parcours) {
		long id = creer();
		
		modifier(id, distance, duree, vitesse, rythmeCardiaque, calorie, sport, playlist, meteo, parcours);
		
		return id;
	}
	/******************************************************************/

	
	
	
	/******************************************************************\
	 * Read
	\******************************************************************/
	@GET @Path("afficher/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Seance getSeance(@PathParam("id") long id) {
		Query query = entityManager.createQuery ("SELECT seances FROM Seance as seances where seances.id=:p_id");
		query.setParameter("p_id", id);
		
		return (Seance)query.getSingleResult();
	}


	@SuppressWarnings("unchecked")
	@GET @Path("afficher")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Seance> getSeances() {
		Query query = entityManager.createQuery ("SELECT seances FROM Seance as seances");
		
		return query.getResultList();
	}
	/******************************************************************/
	
	
	
	
	/******************************************************************\
	 * Update
	\******************************************************************/
	@POST @Path("modifier/{id}/{distance}/{duree}/{vitesse}/{rythmeCardiaque}/{calorie}/{sport}/{playlist}/{meteo}/{parcours}")
	public void modifier(	@PathParam("id") long id,
							@PathParam("distance") int distance,
							@PathParam("duree") int duree,
							@PathParam("vitesse") int vitesse,
							@PathParam("rythmeCardiaque") int rythmeCardiaque,
							@PathParam("calorie") int calorie,
							@PathParam("sport") int sport,
							@PathParam("playlist") int playlist,
							@PathParam("meteo") String meteo,
							@PathParam("parcours") int parcours) {
		modifierDistance(id, distance);
		modifierDuree(id, duree);
		modifierVitesse(id, vitesse);
		modifierRythmeCardiaque(id, rythmeCardiaque);
		modifierCalorie(id, calorie);
		
//		TypeSportService typeSportService = new TypeSportServiceImpl();
//		definirTypeDeSport(id, typeSportService.getTypeSport(sport));
//		
//		ListeChansonService playlistService = new ListeChansonServiceImpl();
//		definirListeChanson(id, playlistService.getListeChanson(playlist));
//		
//		MeteoService meteoService = new MeteoServiceImpl();
//		definirMeteo(id, meteoService.getMeteo(meteo));
//		
//		ParcoursService parcoursService = new ParcoursServiceImpl();
//		definirParcours(id, parcoursService.getParcours(parcours));
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

	@POST @Path("modifierVitesse/{id}/{vitesse}")
	public void modifierVitesse(@PathParam("id") long id, @PathParam("vitesse") int vitesse) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		seance.setVitesse(vitesse);
		
		transaction.commit();
	}

	@POST @Path("modifierCalorie/{id}/{calorie}")
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

	
	@POST @Path("modifierParcours/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void definirParcours(@PathParam("id") long id, Parcours parcours) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		seance.setParcours(parcours);
		
		transaction.commit();
	}

	@POST @Path("modifierListeChansons/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void definirListeChanson(@PathParam("id") long id, ListeChanson listeChansons) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		seance.setListeChanson(listeChansons);
		
		transaction.commit();
	}

	@POST @Path("modifierTypeDeSport/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void definirTypeDeSport(@PathParam("id") long id, TypeSport typeSport) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		seance.setTypeSport(typeSport);
		
		transaction.commit();
	}

	@POST @Path("modifierMeteo/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void definirMeteo(@PathParam("id") long id, Meteo meteo) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		seance.setMeteo(meteo);
		
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
		
		Seance seance = getSeance(id);
		entityManager.remove(seance);
		
		transaction.commit();
	}
	/******************************************************************/
}
