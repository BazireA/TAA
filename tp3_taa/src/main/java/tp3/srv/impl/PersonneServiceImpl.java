package tp3.srv.impl;

import java.util.Collection;
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

import tp3.EntityMan;
import tp3.Personne;
import tp3.srv.PersonneService;

@Path("/personnes")
public class PersonneServiceImpl implements PersonneService{

	private EntityManager entityManager;
	
	
	/******************************************************************\
	 * Constructeur
	\******************************************************************/
	public PersonneServiceImpl() {
		entityManager = EntityMan.getInstance();
	}
	/******************************************************************/

	
	

	/******************************************************************\
	 * Create
	\******************************************************************/
	@PUT @Path("creer/{nom}/{prenom}/{email}/{motDePasse}")
	public long creer(@PathParam("nom") String nom, @PathParam("prenom") String prenom, @PathParam("email") String email, @PathParam("motDePasse") String motDePasse) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Personne personne = new Personne();
		entityManager.persist(personne);
		personne.setNom(nom);
		personne.setPrenom(prenom);
		personne.setAdresseMail(email);
		personne.setMotDePasse(motDePasse);
		
		transaction.commit();
		
		return personne.getId();
	}
	/******************************************************************/

	
	
	
	/******************************************************************\
	 * Read
	\******************************************************************/
	@GET @Path("afficher/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Personne getPersonne(@PathParam("id") long id){
		Query query = entityManager.createQuery ("SELECT personnes FROM Personne as personnes where personnes.id=:p_id");
		query.setParameter("p_id", id);
		
		return (Personne)query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@GET @Path("afficher")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Personne> getPersonnes(){
		Query query = entityManager.createQuery ("SELECT personnes FROM Personne as personnes");
		
		return query.getResultList();
	}
	/******************************************************************/

	
	
	
	/******************************************************************\
	 * Update
	\******************************************************************/
	@POST @Path("modifier/{id}/{nouveauNom}/{nouveauPrenom}/{nouvelEmail}/{nouveauMotDePasse}")
	public void modifier(@PathParam("id") long id, @PathParam("nouveauNom") String nouveauNom, @PathParam("nouveauPrenom") String nouveauPrenom, @PathParam("nouvelEmail") String nouvelEmail, @PathParam("nouveauMotDePasse") String nouveauMotDePasse) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Personne personne = getPersonne(id);
		personne.setNom(nouveauNom);
		personne.setPrenom(nouveauPrenom);
		personne.setAdresseMail(nouvelEmail);
		personne.setMotDePasse(nouveauMotDePasse);
		
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
		
		Personne personne = getPersonne(id);
		entityManager.remove(personne);
		
		transaction.commit();
	}
	/******************************************************************/
	
	
	
	@GET @Path("rechercherAmis/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Collection<Personne> rechercherAmis(@PathParam("id") long id) {
		Personne personne = getPersonne(id);
		
		return personne.getAmis();
	}
}