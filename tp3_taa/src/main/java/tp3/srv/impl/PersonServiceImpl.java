package tp3.srv.impl;

import java.util.Collection;
import java.util.List;

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
import tp3.Personne;
import tp3.srv.PersonService;

@Path("/personnes")
public class PersonServiceImpl implements PersonService{

	private EntityManager entityManager;
	
	
	public PersonServiceImpl() {
		entityManager = EntityMan.getInstance();
	}
	

	@GET @Path("afficher/{nom}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Personne getPersonne(@PathParam("nom") String nom){
		Query query = entityManager.createQuery ("SELECT personnes FROM Personne as personnes where personnes.name=:p_name");
		query.setParameter("p_name", nom);
		
		@SuppressWarnings("unchecked")
		List<Personne> results = query.getResultList();
		
		if(!results.isEmpty())
			return results.get(0);
		else
			return null;
	}

	
	@PUT @Path("creer/{nom}")
	public void creerPersonne(@PathParam("nom") String nom, @PathParam("prenom") String prenom, @PathParam("email") String email, @PathParam("facebook") String facebook) {
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
	
	
	@POST @Path("modifier/{nom}/{nouveauNom}/{nouveauPrenom}/{nouvelEmail}/{nouveauFacebook}")
	public void modifierPersonne(@PathParam("nom") String nom, @PathParam("nouveauNom") String nouveauNom, @PathParam("nouveauPrenom")String nouveauPrenom, @PathParam("nouvelEmail")String nouvelEmail, @PathParam("nouveauFacebook")String nouveauFacebook) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Personne personne = getPersonne(nom);
		personne.setNom(nouveauNom);
		personne.setPrenom(nouveauPrenom);
		personne.setAdresseMail(nouvelEmail);
		personne.setCompteFacebook(nouveauFacebook);
		
		transaction.commit();
	}

	
	@GET @Path("rechercheAmis/{nom}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Collection<Personne> rechercherAmi(@PathParam("nom") String nom) {
		Personne personne = getPersonne(nom);
		
		if(personne != null)
			return personne.getAmis();
		else
			return null;
	}
}