package tp3.srv;

import java.util.List;

import tp3.ListeChanson;

public interface ListeChansonService {

	/******************************************************************\
	 * Create
	\******************************************************************/
	public long creer(String nom);

	
	/******************************************************************\
	 * Read
	\******************************************************************/
	public ListeChanson getListeChanson(long id);
	public List<ListeChanson> getListesChanson();
	
	
	/******************************************************************\
	 * Update
	\******************************************************************/
	public void modifierNomListe(long id, String nouveauNom);
	public void ajouterChanson(long id, long idChanson);
	public void supprimerChanson(long id, long idChanson);
	
	
	/******************************************************************\
	 * Delete
	\******************************************************************/
	public void supprimer(long id);
}
