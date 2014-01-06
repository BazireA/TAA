package tp3.srv;

import java.util.Collection;
import java.util.List;

import tp3.Personne;

public interface PersonneService {

	/******************************************************************\
	 * Create
	\******************************************************************/
	public long creer(String nom, String prenom, String email, String motDePasse);
	
	
	/******************************************************************\
	 * Read
	\******************************************************************/
	public Personne getPersonne(long id);
	public List<Personne> getPersonnes();
	
	
	/******************************************************************\
	 * Update
	\******************************************************************/
	public void modifier(long id, String nouveauNom, String nouveauPrenom, String nouvelEmail, String nouveauMotDePasse);
	
	
	/******************************************************************\
	 * Delete
	\******************************************************************/
	public void supprimer(long id);
	
	
	public Collection<Personne> rechercherAmis(long id);
}
