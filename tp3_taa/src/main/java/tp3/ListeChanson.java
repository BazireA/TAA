package tp3;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;



@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ListeChanson
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
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "listeChanson")
	protected Set<Seance> seance;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	protected Set<Chanson> chanson;
	/******************************************************************/
	
	
	
	
	/******************************************************************\
	 * Constructeurs
	\******************************************************************/
	public ListeChanson(){
		super();
	}
	
	public ListeChanson(String nom){
		super();
		this.nom = nom;
	}
	/******************************************************************/

	
	
	
	/******************************************************************\
	 * Getters
	\******************************************************************/
	public long getId() { return this.id; }
	public String getNom() { return this.nom; }
	
	@JsonIgnore
	public Set<Seance> getSeance() {
		if(this.seance == null)
			this.seance = new HashSet<Seance>();
		
		return (Set<Seance>) this.seance;	
	}
	
	public Set<Chanson> getChanson() {
		if(this.chanson == null)
			this.chanson = new HashSet<Chanson>();
	
		return (Set<Chanson>) this.chanson;	
	}
	/******************************************************************/
	
	
	
	
	/******************************************************************\
	 * Setters
	\******************************************************************/
	public void setNom(String myNom) {
		this.nom = myNom;	
	}
	
	
	public void addSeance(Seance newSeance) {
		if(this.seance == null) {
			this.seance = new HashSet<Seance>();
		}
		
		if (this.seance.add(newSeance))
			newSeance.basicSetListeChanson(this);	
	}
	
	public void removeSeance(Seance oldSeance) {
		if(this.seance == null)
			return;
		
		if (this.seance.remove(oldSeance))
			oldSeance.unsetListeChanson();
			
	}

	
	public void addChanson(Chanson newChanson) {
		if(this.chanson == null) {
			this.chanson = new HashSet<Chanson>();
		}
		
		if (this.chanson.add(newChanson))
			newChanson.addListeChanson(this);	
	}
	
	public void removeChanson(Chanson oldChanson) {
		if(this.chanson == null)
			return;
		
		if (this.chanson.remove(oldChanson))
			oldChanson.removeListeChanson(this);
	}
	
	
	public void addAllSeance(Set<Seance> newSeance) {
		if (this.seance == null)
			this.seance = new HashSet<Seance>();
		
		for (Seance tmp : newSeance)
			tmp.setListeChanson(this);
	}
	
	public void removeAllSeance(Set<Seance> newSeance) {
		if(this.seance == null)
			return;
		
		this.seance.removeAll(newSeance);	
	}
	
	
	public void addAllChanson(Set<Chanson> newChanson) {
		if (this.chanson == null)
			this.chanson = new HashSet<Chanson>();
		
		for (Chanson tmp : newChanson)
			tmp.addListeChanson(this);
	}
	
	public void removeAllChanson(Set<Chanson> newChanson) {
		if(this.chanson == null)
			return;

		this.chanson.removeAll(newChanson);	
	}
	/******************************************************************/
	
	
	

	/******************************************************************\
	 * Unsetters
	\******************************************************************/
	public void unsetNom() {
		this.nom = "";	
	}
	/******************************************************************/
}

