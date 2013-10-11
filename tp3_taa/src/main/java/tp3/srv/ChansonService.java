package tp3.srv;

import tp3.Chanson;

public interface ChansonService {

	public Chanson creerChanson(String nom, int duree);
	public void supprimerChanson(String nom);
}
