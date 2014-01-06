package tp3;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;



@Entity
public class Parcours
{
	/******************************************************************\
	 * Attributs
	\******************************************************************/
	@Id
	@Column(nullable = false)
	@GeneratedValue
	protected final Long id = 0L;
	
	@Column(nullable = false)
	protected String nom;
	
	@OneToOne
	protected Personne champion;
	
	@ManyToMany(mappedBy = "parcours")
	protected Set<PointGPS> pointGPS;
	/******************************************************************/
	
	
	
	
	/******************************************************************\
	 * Constructeur
	\******************************************************************/
	public Parcours(){
		super();
	}
	/******************************************************************/

	

	
	/******************************************************************\
	 * 
	\******************************************************************/
	public void basicSetChampion(Personne myChampion) {
		if (this.champion != myChampion) {
			if (myChampion != null){
				if (this.champion != myChampion) {
					Personne oldchampion = this.champion;
					this.champion = myChampion;
					if (oldchampion != null)
						oldchampion.unsetParcours();
				}
			}
		}	
	}
	/******************************************************************/
	
	
	
	
	/******************************************************************\
	 * Getters
	\******************************************************************/
	public long getId() { return this.id; }
	public String getNom() { return this.nom; }
	public Personne getChampion() { return this.champion; }
	
	public Set<PointGPS> getPointGPS() {
		if(this.pointGPS == null)
			this.pointGPS = new HashSet<PointGPS>();

		return (Set<PointGPS>) this.pointGPS;	
	}
	/******************************************************************/
	
	
	
	
	/******************************************************************\
	 * Setters
	\******************************************************************/
	public void setNom(String myNom) {
		this.nom = myNom;	
	}
	
	public void setChampion(Personne myChampion) {
		this.basicSetChampion(myChampion);
		myChampion.basicSetParcours(this);
	}

	
	public void addPointGPS(PointGPS newPointGPS) {
		if(this.pointGPS == null)
			this.pointGPS = new HashSet<PointGPS>();
		
		if (this.pointGPS.add(newPointGPS))
			newPointGPS.addParcours(this);	
	}	
	
	public void removePointGPS(PointGPS oldPointGPS) {
		if(this.pointGPS == null)
			return;
		
		if (this.pointGPS.remove(oldPointGPS))
			oldPointGPS.removeParcours(this);
	}
	
	
	public void addAllPointGPS(Set<PointGPS> newPointGPS) {
		if (this.pointGPS == null)
			this.pointGPS = new HashSet<PointGPS>();
			
		for (PointGPS tmp : newPointGPS)
			tmp.addParcours(this);
	}
	
	public void removeAllPointGPS(Set<PointGPS> newPointGPS) {
		if(this.pointGPS == null)
			return;
		
		this.pointGPS.removeAll(newPointGPS);	
	}
	/******************************************************************/
	
	
	
	
	/******************************************************************\
	 * Unsetters
	\******************************************************************/
	public void unsetChampion() {
		if (this.champion == null)
			return;
		
		Personne oldchampion = this.champion;
		this.champion = null;
		oldchampion.unsetParcours();	
	}
	/******************************************************************/
}

