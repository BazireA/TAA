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
import tp3.Meteo;
import tp3.srv.MeteoService;

@Path("/meteo")
public class MeteoServiceImpl implements MeteoService {

	private EntityManager entityManager;
	
	
	public MeteoServiceImpl() {
		entityManager = EntityMan.getInstance();
	}
	
	
	@PUT @Path("creer/{temps}")
	public long creerMeteo(@PathParam("temps") String temps) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Meteo meteo = new Meteo();
		meteo.setTemps(temps);
		entityManager.persist(meteo);
		
		transaction.commit();
		
		return meteo.getId();
	}

	@GET @Path("afficher/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Meteo getMeteo(@PathParam("id") long id) {
		Query query = entityManager.createQuery ("SELECT meteo FROM Meteo as meteo where meteo.id=:p_id");
		query.setParameter("p_id", id);
		
		return (Meteo)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@GET @Path("afficher")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Meteo> getMeteos() {
		Query query = entityManager.createQuery ("SELECT meteo FROM Meteo as meteo");
		
		return query.getResultList();
	}
	

	@GET @Path("tempsLibelles")
	@Produces({ MediaType.APPLICATION_JSON })
	public String[] getTempsLibelles() {
		return Meteo.tempsLibelles;
	}

	@POST @Path("modifier/{id}/{temps}/{temperature}/{vent}/{uv}")
	public void modifier(@PathParam("id") long id, @PathParam("temps") String temps, @PathParam("temperature") int temperature, @PathParam("vent") int vent, @PathParam("uv") int uv) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Meteo meteo = getMeteo(id);
		meteo.setTemps(temps);
		meteo.setTemperature(temperature);
		meteo.setVent(vent);
		meteo.setUv(uv);
		
		transaction.commit();
	}

	@DELETE @Path("supprimerMeteo/{id}")
	public void supprimerMeteo(@PathParam("id") long id) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Meteo meteo = getMeteo(id);
		entityManager.remove(meteo);
		
		transaction.commit();
	}
}
