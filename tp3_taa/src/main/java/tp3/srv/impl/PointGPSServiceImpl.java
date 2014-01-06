package tp3.srv.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tp3.EntityMan;
import tp3.PointGPS;
import tp3.srv.PointGPSService;

@Path("/pointgps")
public class PointGPSServiceImpl implements PointGPSService {
	
	private EntityManager entityManager;
	
	
	/******************************************************************\
	 * Constructeur
	\******************************************************************/
	public PointGPSServiceImpl() {
		entityManager = EntityMan.getInstance();
	}
	/******************************************************************/
	
	
	
	
	/******************************************************************\
	 * Create
	\******************************************************************/
	@PUT @Path("creer")
	public long creer(@PathParam("latitude") int latitude, @PathParam("longitude") int longitude) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		PointGPS pointGPS = new PointGPS(latitude, longitude);
		
		entityManager.persist(pointGPS);
		
		transaction.commit();
		
		return pointGPS.getId();
	}
	/******************************************************************/

	
	
	
	/******************************************************************\
	 * Read
	\******************************************************************/
	@GET @Path("afficher/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public PointGPS getPointGPS(@PathParam("id") long id) {
		Query query = entityManager.createQuery ("SELECT pointsGPS FROM PointGPS as pointsGPS where pointsGPS.id=:p_id");
		query.setParameter("p_id", id);
		
		return (PointGPS)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@GET @Path("afficher")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<PointGPS> getPointsGPS() {
		Query query = entityManager.createQuery ("SELECT pointsGPS FROM PointGPS as pointsGPS");
		
		return query.getResultList();
	}
	/******************************************************************/

	
	
	
	/******************************************************************\
	 * Update
	\******************************************************************/
	@POST @Path("modifier/{id}/{latitude}/{longitude}")
	public void modifier(@PathParam("id") long id, @PathParam("latitude") int latitude, @PathParam("longitude") int longitude) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		PointGPS pointGPS = getPointGPS(id);
		pointGPS.setLatitude(latitude);
		pointGPS.setLongitude(longitude);
		
		transaction.commit();
	}
	/******************************************************************/

	
	
	
	/******************************************************************\
	 * Delete
	\******************************************************************/
	@DELETE @Path("supprimer/{id}")
	public void supprimer(@PathParam("id") long id) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		PointGPS pointGPS = getPointGPS(id);
		entityManager.remove(pointGPS);
		
		transaction.commit();
	}
	/******************************************************************/
}
