package tp3;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.codehaus.jackson.annotate.JsonIgnore;


@Entity
public class Chanson
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
		
	@Column(nullable = false)
	protected int duree;
	
	@ManyToMany(mappedBy = "chanson")
	protected Set<ListeChanson> listeChanson;
	/******************************************************************/
	
	
	
	
	/******************************************************************\
	 * Constructeur
	\******************************************************************/
	public Chanson(){
		super();
	}
	/******************************************************************/
	
	
	
	
	/******************************************************************\
	 * Getters
	\******************************************************************/
	public long getId() { return this.id; }
	public String getNom() { return this.nom; }
	public int getDuree() { return this.duree; }
	
	@JsonIgnore
	public Set<ListeChanson> getListeChanson() {
		if(this.listeChanson == null) {
				this.listeChanson = new HashSet<ListeChanson>();
		}
		return (Set<ListeChanson>) this.listeChanson;	
	}
	/******************************************************************/
	

	
	
	
	/******************************************************************\
	 * Setters
	\******************************************************************/
	public void setNom(String myNom) {
		this.nom = myNom;	
	}
	
	public void setDuree(int myDuree) {
		this.duree = myDuree;	
	}
	
	
	public void addListeChanson(ListeChanson newListeChanson) {
		if(this.listeChanson == null)
			this.listeChanson = new HashSet<ListeChanson>();
		
		if (this.listeChanson.add(newListeChanson))
			newListeChanson.addChanson(this);	
	}
	
	public void removeListeChanson(ListeChanson oldListeChanson) {
		if(this.listeChanson == null)
			return;
		
		if (this.listeChanson.remove(oldListeChanson))
			oldListeChanson.removeChanson(this);
	}
	
	
	public void addAllListeChanson(Set<ListeChanson> newListeChanson) {
		if (this.listeChanson == null)
			this.listeChanson = new HashSet<ListeChanson>();

		for (ListeChanson tmp : newListeChanson)
			tmp.addChanson(this);
	}
	
	public void removeAllListeChanson(Set<ListeChanson> newListeChanson) {
		if(this.listeChanson == null)
			return;
		
		this.listeChanson.removeAll(newListeChanson);	
	}
	/******************************************************************/
	
	
	
	
	/******************************************************************\
	 * Unsetters
	\******************************************************************/
	public void unsetNom() {
		this.nom = "";	
	}
	
	public void unsetDuree() {
		this.duree = 0;	
	}
	/******************************************************************/
}

