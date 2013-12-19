package tp3.srv;

import tp3.Chanson;
import tp3.ListeChanson;

public interface ListeChansonService {

	public void creerListeChanson(String nom);
	public void modifierNomListe(long id, String nouveauNom);
	public void supprimerChanson(long id, Chanson chanson);
	public void ajouterChanson(long id,Chanson chanson);
	public ListeChanson getListeChanson(long id);
}
