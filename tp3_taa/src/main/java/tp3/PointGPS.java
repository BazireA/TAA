package tp3;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class PointGPS
{
	/******************************************************************\
	 * Attributs
	\******************************************************************/
	@Id
	@Column(nullable = false)
	@GeneratedValue
	protected final Long id = 0L;
	
	@Column(nullable = false)
	protected int latitude;
	
	@Column(nullable = false)
	protected int longitude;
	
	@ManyToMany
	protected Set<Parcours> parcours;
	/******************************************************************/
	
	


	/******************************************************************\
	 * Constructeur
	\******************************************************************/
	public PointGPS(int latitude, int longitude) {
		super();
		
		this.latitude = latitude;
		this.longitude = longitude;
	}
	/******************************************************************/
	
	
	

	/******************************************************************\
	 * Getters
	\******************************************************************/
	public long getId() { return this.id; }
	public int getLatitude() { return this.latitude; }
	public int getLongitude() { return this.longitude; }
	
	public Set<Parcours> getParcours() {
		if(this.parcours == null)
			this.parcours = new HashSet<Parcours>();

		return (Set<Parcours>) this.parcours;	
	}
	/******************************************************************/
	
	
	
	
	/******************************************************************\
	 * Setters
	\******************************************************************/
	public void setLatitude(int latitude) {
		this.latitude = latitude;	
	}
	
	public void setLongitude(int longitude) {
		this.longitude = longitude;	
	}
	
	
	public void addParcours(Parcours newParcours) {
		if(this.parcours == null) {
			this.parcours = new HashSet<Parcours>();
		}
		
		if (this.parcours.add(newParcours))
			newParcours.addPointGPS(this);	
	}
	
	public void removeParcours(Parcours oldParcours) {
		if(this.parcours == null)
			return;
		
		if (this.parcours.remove(oldParcours))
			oldParcours.removePointGPS(this);
	}
	
	
	public void addAllParcours(Set<Parcours> newParcours) {
		if (this.parcours == null)
			this.parcours = new HashSet<Parcours>();

		for (Parcours tmp : newParcours)
			tmp.addPointGPS(this);
	}
	
	public void removeAllParcours(Set<Parcours> newParcours) {
		if(this.parcours == null) {
			return;
		}
		
		this.parcours.removeAll(newParcours);	
	}
	/******************************************************************/
	
	
	
	
	/******************************************************************\
	 * Unsetters
	\******************************************************************/
	public void unsetLatitude() {
		this.latitude = 0;	
	}
	
	public void unsetLongitude() {
		this.longitude = 0;	
	}
	/******************************************************************/
}

