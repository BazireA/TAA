package tp3.srv.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import tp3.Chanson;
import tp3.ListeChanson;
import tp3.srv.ChansonService;

public class ChansonServiceImpl implements ChansonService {

	private EntityManager entityManager;
	
	
	public ChansonServiceImpl(EntityManager entityManager) {
		super();
		this.setEntityManager(entityManager);
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	
	public Chanson creerChanson(String nom, int duree) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Chanson chanson = new Chanson();
		chanson.setNom(nom);
		chanson.setDuree(duree);
		entityManager.persist(chanson);
		
		transaction.commit();
		
		return chanson;
	}

	
	public void supprimerChanson(String nom) {		
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
