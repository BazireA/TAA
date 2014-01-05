package tp3.srv;

import java.util.List;

import tp3.Chanson;

public interface ChansonService {

	/******************************************************************\
	 * Create
	\******************************************************************/
	public long creerChanson(String nom, int duree);
	
	
	/******************************************************************\
	 * Read
	\******************************************************************/
	public Chanson getChanson(long id);
	public List<Chanson> getChansons();
	
	
	/******************************************************************\
	 * Update
	\******************************************************************/
	public void modifier(long id, String nom, int duree);
	
	
	/******************************************************************\
	 * Delete
	\******************************************************************/
	public void supprimerChanson(long id);
}
