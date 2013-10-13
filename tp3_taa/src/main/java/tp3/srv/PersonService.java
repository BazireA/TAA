package tp3.srv;

import java.util.Collection;

import tp3.Personne;

public interface PersonService {

	public void creerPersonne(String nom, String prenom, String email, String facebook);
	public void modifierPersonne(String nom, String nouveauNom, String nouveauPrenom, String nouvelEmail, String nouveauFacebook);
	public Collection<Personne> rechercherAmi(String nom);
}
