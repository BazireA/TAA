package tp3.srv.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import tp3.Chanson;
import tp3.ListeChanson;
import tp3.srv.ListeChansonService;

public class ListeChansonServiceImpl implements ListeChansonService{

	private EntityManager em;

	
	public ListeChansonServiceImpl(EntityManager em) {
		super();
		this.setEm(em);
	}
	

	public EntityManager getEm() {
		return em;
	}


	public void setEm(EntityManager em) {
		this.em = em;
	}


	public void creerListeChanson(String nom) {
		ListeChanson chanson = new ListeChanson(nom);
		em.persist(chanson);
	}
	
	public void ajouterChanson(String nomListe, Chanson chanson) {
		
		Query q = em.createQuery ("SELECT a FROM ListeChanson as a where a.nom=:toto");
		q.setParameter("toto", nomListe);
		List<ListeChanson> results = q.getResultList();

		EntityTransaction t = em.getTransaction();
		t.begin();
		results.get(0).addChanson(chanson);
		t.commit();
	}


	
	
	
	private ListeChanson getListeChanson(String nomListe){
		Query q = em.createQuery ("SELECT a FROM ListeChanson as a where a.nom=:toto");
		q.setParameter("toto", nomListe);
		List<ListeChanson> results = q.getResultList();
		
		return results.get(0);
	}

	
	public void supprimerChanson(String nomListe, Chanson chanson) {
		ListeChanson listeChanson = getListeChanson(nomListe);

		listeChanson.removeChanson(chanson);
	}

	public void modifierNomListe(String nomListe, String nouveauNom) {
		ListeChanson listeChanson = getListeChanson(nomListe);

		listeChanson.setNom(nouveauNom);
	}
}
