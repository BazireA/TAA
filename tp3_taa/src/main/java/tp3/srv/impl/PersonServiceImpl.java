package tp3.srv.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import tp3.Personne;
import tp3.srv.PersonService;

public class PersonServiceImpl implements PersonService{

	private EntityManager em;
	
	public PersonServiceImpl(EntityManager em) {
		super();
		this.setEm(em);
	}

	public void createPerson(String name,String prenom,String email,String facebook) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		Personne e1 = new Personne();
		em.persist(e1);
		e1.setNom(name);
		e1.setPrenom(prenom);
		e1.setAdresseMail(email);
		e1.setCompteFacebook(facebook);	
		t.commit();
	}

	public Collection<Personne> rechercherAmi(String name) {
		Query q = em.createQuery ("SELECT a FROM Personne as a where name=:toto");
		q.setParameter("toto", name);
		List<Personne> results = q.getResultList();
		
		return results.get(0).getAmis();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
