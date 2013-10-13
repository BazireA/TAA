package tp3.srv.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import tp3.ListeChanson;
import tp3.Meteo;
import tp3.Parcours;
import tp3.Seance;
import tp3.TypeSport;
import tp3.srv.SeanceService;

public class SeanceServiceImpl implements SeanceService {

private EntityManager entityManager;

	
	public SeanceServiceImpl(EntityManager entityManager) {
		super();
		this.setEntityManager(entityManager);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	
	private Seance getSeance(long id) {
		Query query = entityManager.createQuery ("SELECT seances FROM Seance as seances where seances.id=:p_id");
		query.setParameter("p_id", id);
		
		return (Seance)query.getSingleResult();
	}
	
	
	
	public void creerSeance() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = new Seance();
		entityManager.persist(seance);
		
		transaction.commit();
	}

	
	public void modifierDuree(long id, int duree) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		seance.setDuree(duree);
		
		transaction.commit();
	}

	
	public void modifierDistance(long id, int distance) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		seance.setDistance(distance);
		
		transaction.commit();
	}

	
	public void modifierVitesse(long id, int vitesse) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		seance.setVitesse(vitesse);
		
		transaction.commit();
	}

	
	public void modifierCalorie(long id, int calorie) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		seance.setCalorie(calorie);
		
		transaction.commit();
	}

	
	public void modifierRythmeCardiaque(long id, int rythmeCardiaque) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		seance.setRythmeCardiaque(rythmeCardiaque);
		
		transaction.commit();
	}

	
	public void modifierObjectif(long id, int objectif) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		seance.setObjectif(objectif);
		
		transaction.commit();
	}

	
	public void definirParcours(long id, Parcours parcours) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		seance.setParcours(parcours);
		
		transaction.commit();
	}

	
	public void definirListeChanson(long id, ListeChanson listeChansons) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		seance.setListeChanson(listeChansons);
		
		transaction.commit();
	}

	
	public void definirTypeDeSport(long id, TypeSport typeSport) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		seance.setTypeSport(typeSport);
		
		transaction.commit();
	}

	
	public void definirMeteo(long id, Meteo meteo) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		seance.setMeteo(meteo);
		
		transaction.commit();
	}

	
	public void supprimerSeance(long id) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Seance seance = getSeance(id);
		entityManager.remove(seance);
		
		transaction.commit();
	}
}
