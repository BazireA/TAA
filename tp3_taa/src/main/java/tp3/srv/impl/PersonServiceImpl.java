package tp3.srv.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import tp3.Personne;
import tp3.srv.PersonService;

public class PersonServiceImpl implements PersonService{

	private EntityManager entityManager;
	
	
	public PersonServiceImpl(EntityManager entityManager) {
		super();
		this.setEntityManager(entityManager);
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	

	
	private Personne getPersonne(String nom){
		Query query = entityManager.createQuery ("SELECT personnes FROM Personne as personnes where personnes.name=:p_name");
		query.setParameter("p_name", nom);
		
		@SuppressWarnings("unchecked")
		List<Personne> results = query.getResultList();
		
		if(!results.isEmpty())
			return results.get(0);
		else
			return null;
	}

	
	
	public void creerPersonne(String nom, String prenom, String email, String facebook) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Personne personne = new Personne();
		entityManager.persist(personne);
		personne.setNom(nom);
		personne.setPrenom(prenom);
		personne.setAdresseMail(email);
		personne.setCompteFacebook(facebook);
		
		transaction.commit();
	}
	
	
	public void modifierPersonne(String nom, String nouveauNom, String nouveauPrenom, String nouvelEmail, String nouveauFacebook) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Personne personne = getPersonne(nom);
		personne.setNom(nouveauNom);
		personne.setPrenom(nouveauPrenom);
		personne.setAdresseMail(nouvelEmail);
		personne.setCompteFacebook(nouveauFacebook);
		
		transaction.commit();
	}

	
	public Collection<Personne> rechercherAmi(String nom) {
		Personne personne = getPersonne(nom);
		
		if(personne != null)
			return personne.getAmis();
		else
			return null;
	}
}