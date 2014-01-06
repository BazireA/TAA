package tp3.srv;

import java.util.List;

import tp3.PointGPS;

public interface PointGPSService {

	/******************************************************************\
	 * Create
	\******************************************************************/
	public long creer(int latitude, int longitude);
	
	
	/******************************************************************\
	 * Read
	\******************************************************************/
	public PointGPS getPointGPS(long id);
	public List<PointGPS> getPointsGPS();
	
	
	/******************************************************************\
	 * Update
	\******************************************************************/
	public void modifier(long id, int latitude, int longitude);
	
	
	/******************************************************************\
	 * Delete
	\******************************************************************/
	public void supprimer(long id);
}
