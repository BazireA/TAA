package tp3.srv;

import java.util.List;

import tp3.Meteo;

public interface MeteoService {

	public long creerMeteo(String temps);
	public Meteo getMeteo(long id);
	public List<Meteo> getMeteos();
	public void modifier(long id, String temps, int temperature, int vent, int uv);
	public void supprimerMeteo(long id);
}
