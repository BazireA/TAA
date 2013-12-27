package tp3.srv;

import java.util.List;

import tp3.Meteo;

public interface MeteoService {

	/******************************************************************\
	 * Create
	\******************************************************************/
	public long creerMeteo(String temps);
	
	
	/******************************************************************\
	 * Read
	\******************************************************************/
	public Meteo getMeteo(long id);
	public List<Meteo> getMeteos();
	
	
	/******************************************************************\
	 * Update
	\******************************************************************/
	public void modifier(long id, String temps, int temperature, int vent, int uv);
	
	
	/******************************************************************\
	 * Delete
	\******************************************************************/
	public void supprimerMeteo(long id);
}
