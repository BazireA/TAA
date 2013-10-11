package tp3.srv;

import java.util.Collection;

import tp3.Personne;

public interface PersonService {
	
	public void createPerson(String name,String prenom,String email,String facebook);
	public Collection<Personne> rechercherAmi(String name);
	

}
