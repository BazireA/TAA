package tp3.srv;

import tp3.Chanson;
import tp3.ListeChanson;

public interface ListeChansonService {

	public void creerListeChanson(String nom);
	public void modifierNomListe(String nomListe, String nouveauNom);
	public void supprimerChanson(String nomListe, Chanson chanson);
	public void ajouterChanson(String nomListe,Chanson chanson);
	public ListeChanson getListeChanson(String nomListe);
}
