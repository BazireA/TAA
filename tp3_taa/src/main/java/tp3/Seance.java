package tp3;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Seance
{
	/******************************************************************\
	 * Attributs
	\******************************************************************/
	@Id
	@Column(nullable = false)
	@GeneratedValue
	protected final Long id = 0L;
	
	@Column(nullable = true)
	protected int duree;
	
	@Column(nullable = true)
	protected int distance;
	
	@Column(nullable = true)
	protected int vitesse;
	
	@Column(nullable = true)
	protected int calorie;
	
	@Column(nullable = true)
	protected int rythmeCardiaque;
	
	@Column(nullable = true)
	protected int objectif;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(nullable = true)
	protected Parcours parcours;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(nullable = true)
	protected ListeChanson listeChanson;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(nullable = true)
	protected TypeSport typeSport;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(nullable = true)
	protected Meteo meteo;
	
	@ManyToMany
	protected Set<Personne> personne;
	/******************************************************************/

	
	
	
	/******************************************************************\
	 * Constructeur
	\******************************************************************/
	public Seance() {
		super();
	}
	/******************************************************************/
	
	
	
	/******************************************************************\
	 * 
	\******************************************************************/
	public void basicSetListeChanson(ListeChanson listeChanson) {
		
		if ((this.listeChanson != listeChanson) && (listeChanson != null) 
				&& (this.listeChanson != listeChanson)) {
			
			ListeChanson oldListeChanson = this.listeChanson;
			this.listeChanson = listeChanson;
			
			if (oldListeChanson != null)
				oldListeChanson.removeSeance(this);
		}
	}

	public void basicSetMeteo(Meteo meteo) {
		
		if ((this.meteo != meteo) && (meteo != null) && (this.meteo != meteo)) {
			
			Meteo oldMeteo = this.meteo;
			this.meteo = meteo;
			
			if (oldMeteo != null)
				oldMeteo.unsetSeance();
		}
	}
	/******************************************************************/


	
	
	/******************************************************************\
	 * Getters
	\******************************************************************/
	public long getId() { return this.id; }
	
	public int getDuree() { return this.duree; }
	public int getDistance() { return this.distance; }
	public int getVitesse() { return this.vitesse; }
	public int getCalorie() { return this.calorie; }
	public int getRythmeCardiaque() { return this.rythmeCardiaque; }
	public int getObjectif() { return this.objectif; }
	
	public Parcours getParcours() { return this.parcours; }
	public ListeChanson getListeChanson() { return this.listeChanson; }
	public TypeSport getTypeSport() { return this.typeSport; }
	public Meteo getMeteo() {  return this.meteo; }
	
	public Set<Personne> getPersonne() {
		if(this.personne == null) {
			this.personne = new HashSet<Personne>();
		}
		return (Set<Personne>) this.personne;
	}
	/******************************************************************/
	
	
	
	
	/******************************************************************\
	 * Setters
	\******************************************************************/
	public void setDuree(int myDuree) {
		this.duree = myDuree;	
	}
	
	public void setDistance(int myDistance) {
		this.distance = myDistance;	
	}
	
	public void setVitesse(int myVitesse) {
		this.vitesse = myVitesse;	
	}
	
	public void setCalorie(int myCalorie) {
		this.calorie = myCalorie;	
	}
	
	public void setRythmeCardiaque(int myRythmeCardiaque) {
		this.rythmeCardiaque = myRythmeCardiaque;	
	}
	
	public void setObjectif(int myObjectif) {
		this.objectif = myObjectif;	
	}
	
	public void setParcours(Parcours myParcours) {
		this.parcours = myParcours;	
	}
	
	public void setListeChanson(ListeChanson myListeChanson) {
		this.basicSetListeChanson(myListeChanson);
		myListeChanson.addSeance(this);	
	}
	
	public void setTypeSport(TypeSport myTypeSport) {
		this.typeSport = myTypeSport;	
	}
	
	public void setMeteo(Meteo myMeteo) {
		this.basicSetMeteo(myMeteo);
		myMeteo.basicSetSeance(this);
	}

	
	
	public void addPersonne(Personne newPersonne) {
		if(this.personne == null)
			this.personne = new HashSet<Personne>();
		
		if (this.personne.add(newPersonne))
			newPersonne.addSeance(this);	
	}
	
	public void removePersonne(Personne oldPersonne) {
		if(this.personne == null)
			return;
		
		if (this.personne.remove(oldPersonne))
			oldPersonne.removeSeance(this);
	}
	
	
	public void addAllPersonne(Set<Personne> personnes) {
		if (this.personne == null)
			this.personne = new HashSet<Personne>();
		
		for (Personne personne : personnes)
			personne.addSeance(this);
	}
	
	public void removeAllPersonne(Set<Personne> personnes) {
		if(this.personne != null)
			this.personne.removeAll(personnes);	
	}
	/******************************************************************/
	
	
	
	
	/******************************************************************\
	 * Unsetters
	\******************************************************************/
	public void unsetDuree() {
		this.duree = 0;	
	}

	public void unsetDistance() {
		this.distance = 0;	
	}
	
	public void unsetVitesse() {
		this.vitesse = 0;	
	}
	
	public void unsetCalorie() {
		this.calorie = 0;	
	}
	public void unsetRythmeCardiaque() {
		this.rythmeCardiaque = 0;	
	}
	
	public void unsetObjectif() {
		this.objectif = 0;	
	}
	
	public void unsetParcours() {
		this.parcours = new Parcours();	
	}
	
	public void unsetListeChanson() {
		if (this.listeChanson == null)
			return;
		
		ListeChanson oldListeChanson = this.listeChanson;
		this.listeChanson = null;
		oldListeChanson.removeSeance(this);	
	}
	
	public void unsetTypeSport() {
		this.typeSport = new TypeSport();	
	}
	
	public void unsetMeteo() {
		if (this.meteo == null)
			return;
		
		Meteo oldMeteo = this.meteo;
		this.meteo = null;
		oldMeteo.unsetSeance();	
	}
	/******************************************************************/
}

