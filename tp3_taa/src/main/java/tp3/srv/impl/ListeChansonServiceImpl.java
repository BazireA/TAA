package tp3.srv.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import tp3.Chanson;
import tp3.ListeChanson;
import tp3.srv.ListeChansonService;

public class ListeChansonServiceImpl implements ListeChansonService {

	private EntityManager entityManager;

	
	public ListeChansonServiceImpl(EntityManager entityManager) {
		super();
		this.setEntityManager(entityManager);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	
	public ListeChanson getListeChanson(String nomListe){
		Query query = entityManager.createQuery ("SELECT listesChansons FROM ListeChanson as listesChansons where listesChansons.nom=:p_nomListe");
		query.setParameter("p_nomListe", nomListe);
		
		@SuppressWarnings("unchecked")
		List<ListeChanson> results = query.getResultList();
		
		if(!results.isEmpty())
			return results.get(0);
		else
			return null;
	}
	
	
	
	public void creerListeChanson(String nom) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		ListeChanson chanson = new ListeChanson(nom);
		entityManager.persist(chanson);
		
		transaction.commit();
	}

	
	public void modifierNomListe(String nomListe, String nouveauNom) {
		ListeChanson listeChanson = getListeChanson(nomListe);

		if(listeChanson != null){
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			
			listeChanson.setNom(nouveauNom);
			
			transaction.commit();
		}
	}

	
	public void supprimerChanson(String nomListe, Chanson chanson) {
		ListeChanson listeChanson = getListeChanson(nomListe);

		if(listeChanson != null){
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			
			listeChanson.removeChanson(chanson);
			
			transaction.commit();
		}
	}
	
	
	public void ajouterChanson(String nomListe, Chanson chanson) {		
		ListeChanson listeChanson = getListeChanson(nomListe);

		if(listeChanson != null) {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			
			listeChanson.addChanson(chanson);
			
			transaction.commit();
		}
	}
}
