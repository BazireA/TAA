package tp3.srv;

import java.util.List;

import tp3.ListeChanson;
import tp3.Meteo;
import tp3.Parcours;
import tp3.Seance;
import tp3.TypeSport;

public interface SeanceService {

	/******************************************************************\
	 * Create
	\******************************************************************/
	public long creer();
	public long creer(
			int distance,
			int duree, int vitesse,
			int rythmeCardiaque, int calorie,
			int sport,
			int playlist,
			int temps,
			int temperature,
			int vent,
			int uv,
			int parcours
	);
	
	
	/******************************************************************\
	 * Read
	\******************************************************************/
	public Seance getSeance(long id);
	public List<Seance> getSeances();
	
	
	/******************************************************************\
	 * Update
	\******************************************************************/
	public void modifier(
			long id,
			int distance,
			int duree,
			int vitesse,
			int rythmeCardiaque,
			int calorie,
			int sport,
			int playlist,
			int meteo,
			int temps,
			int temperature,
			int vent,
			int uv,
			int parcours
	);
	
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
	
	
	/******************************************************************\
	 * Delete
	\******************************************************************/
	public void supprimer(long id);
}
