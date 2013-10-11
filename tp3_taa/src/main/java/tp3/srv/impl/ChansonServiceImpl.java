package tp3.srv.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import tp3.Chanson;
import tp3.ListeChanson;
import tp3.srv.ChansonService;

public class ChansonServiceImpl implements ChansonService {

	private EntityManager em;
	
	
	public ChansonServiceImpl(EntityManager em) {
		super();
		this.setEm(em);
	}
	

	public EntityManager getEm() {
		return em;
	}


	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
	
	public Chanson creerChanson(String nom, int duree) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		
		Chanson chanson = new Chanson();
		chanson.setNom(nom);
		chanson.setDuree(duree);
		em.persist(chanson);
		t.commit();
		
		return chanson;
	}

	public void supprimerChanson(String nom) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		
		Query q = em.createQuery ("SELECT a FROM Chanson as a where a.nom=:toto");
		q.setParameter("toto", nom);
		List<Chanson> results = q.getResultList();
		em.remove(results.get(0));
		
		t.commit();
	}

}
