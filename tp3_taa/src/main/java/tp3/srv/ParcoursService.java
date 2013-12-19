package tp3.srv;

import java.util.List;

import tp3.Parcours;

public interface ParcoursService {
	
	public long creerParcours(String nom);
	public Parcours getParcours(long id);
	public List<Parcours> getParcours();
	public void modifier(long id, String nom);
	public void supprimerSport(long id);
}
