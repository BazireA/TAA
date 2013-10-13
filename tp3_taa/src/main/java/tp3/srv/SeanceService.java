package tp3.srv;

import tp3.ListeChanson;
import tp3.Meteo;
import tp3.Parcours;
import tp3.TypeSport;

public interface SeanceService {

	public void creerSeance();
	public void modifierDuree(long id, int duree);
	public void modifierDistance(long id, int distance);
	public void modifierVitesse(long id, int vitesse);
	public void modifierCalorie(long id, int calorie);
	public void modifierRythmeCardiaque(long id, int rythmeCardiaque);
	public void modifierObjectif(long id, int objectif);
	public void definirParcours(long id, Parcours parcours);
	public void definirListeChanson(long id, ListeChanson listeChansons);
	public void definirTypeDeSport(long id, TypeSport typeSport);
	public void definirMeteo(long id, Meteo meteo);
	public void supprimerSeance(long id);
}
