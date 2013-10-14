package tp3;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.CascadeType;


/**
 * <br>
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

@javax.persistence.Entity
public class Seance
{
	/**
	 * <br>
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@javax.persistence.Column(nullable = true)
	protected int duree;
	/**
	 * <br>
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@javax.persistence.Column(nullable = true)
	protected int distance;
	/**
	 * <br>
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@javax.persistence.Column(nullable = true)
	protected int vitesse;
	/**
	 * <br>
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@javax.persistence.Column(nullable = true)
	protected int calorie;
	/**
	 * <br>
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@javax.persistence.Column(nullable = true)
	protected int rythmeCardiaque;
	/**
	 * <br>
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@javax.persistence.Column(nullable = true)
	protected int objectif;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@javax.persistence.ManyToOne(cascade=CascadeType.PERSIST)
	@javax.persistence.JoinColumn(nullable = true)
	protected Parcours parcours;
	/**
	 * <br>
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@javax.persistence.ManyToOne(cascade=CascadeType.PERSIST)
	protected ListeChanson listeChanson;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@javax.persistence.ManyToOne(cascade=CascadeType.PERSIST)
	@javax.persistence.JoinColumn(nullable = true)
	protected TypeSport typeSport;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@javax.persistence.OneToOne(cascade=CascadeType.PERSIST)
	protected Meteo meteo;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@javax.persistence.ManyToMany
	protected Set<Personne> personne;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	@javax.persistence.Id
	@javax.persistence.Column(nullable = true)
	protected final Long id = 0L;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Seance(){
		super();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void basicSetListeChanson(ListeChanson myListeChanson) {
		if (this.listeChanson != myListeChanson) {
			if (myListeChanson != null){
				if (this.listeChanson != myListeChanson) {
					ListeChanson oldlisteChanson = this.listeChanson;
					this.listeChanson = myListeChanson;
					if (oldlisteChanson != null)
						oldlisteChanson.removeSeance(this);
				}
			}
		}	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void basicSetMeteo(Meteo myMeteo) {
		if (this.meteo != myMeteo) {
			if (myMeteo != null){
				if (this.meteo != myMeteo) {
					Meteo oldmeteo = this.meteo;
					this.meteo = myMeteo;
					if (oldmeteo != null)
						oldmeteo.unsetSeance();
				}
			}
		}	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public int getDuree() {
		return this.duree;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public int getDistance() {
		return this.distance;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public int getVitesse() {
		return this.vitesse;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public int getCalorie() {
		return this.calorie;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public int getRythmeCardiaque() {
		return this.rythmeCardiaque;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public int getObjectif() {
		return this.objectif;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Parcours getParcours() {
		return this.parcours;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public ListeChanson getListeChanson() {
		return this.listeChanson;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public TypeSport getTypeSport() {
		return this.typeSport;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Meteo getMeteo() {
		return this.meteo;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Set<Personne> getPersonne() {
		if(this.personne == null) {
				this.personne = new HashSet<Personne>();
		}
		return (Set<Personne>) this.personne;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public long getId() {
		return this.id;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addAllPersonne(Set<Personne> newPersonne) {
		if (this.personne == null) {
			this.personne = new HashSet<Personne>();
		}
		for (Personne tmp : newPersonne)
			tmp.addSeance(this);
			
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeAllPersonne(Set<Personne> newPersonne) {
		if(this.personne == null) {
			return;
		}
		
		this.personne.removeAll(newPersonne);	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setDuree(int myDuree) {
		this.duree = myDuree;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setDistance(int myDistance) {
		this.distance = myDistance;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setVitesse(int myVitesse) {
		this.vitesse = myVitesse;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setCalorie(int myCalorie) {
		this.calorie = myCalorie;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setRythmeCardiaque(int myRythmeCardiaque) {
		this.rythmeCardiaque = myRythmeCardiaque;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setObjectif(int myObjectif) {
		this.objectif = myObjectif;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setParcours(Parcours myParcours) {
		this.parcours = myParcours;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setListeChanson(ListeChanson myListeChanson) {
		this.basicSetListeChanson(myListeChanson);
		myListeChanson.addSeance(this);	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setTypeSport(TypeSport myTypeSport) {
		this.typeSport = myTypeSport;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setMeteo(Meteo myMeteo) {
		this.basicSetMeteo(myMeteo);
		myMeteo.basicSetSeance(this);
			
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addPersonne(Personne newPersonne) {
		if(this.personne == null) {
			this.personne = new HashSet<Personne>();
		}
		
		if (this.personne.add(newPersonne))
			newPersonne.addSeance(this);	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetDuree() {
		this.duree = 0;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetDistance() {
		this.distance = 0;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetVitesse() {
		this.vitesse = 0;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetCalorie() {
		this.calorie = 0;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetRythmeCardiaque() {
		this.rythmeCardiaque = 0;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetObjectif() {
		this.objectif = 0;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetParcours() {
		this.parcours = new Parcours();	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetListeChanson() {
		if (this.listeChanson == null)
			return;
		ListeChanson oldlisteChanson = this.listeChanson;
		this.listeChanson = null;
		oldlisteChanson.removeSeance(this);	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetTypeSport() {
		this.typeSport = new TypeSport();	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetMeteo() {
		if (this.meteo == null)
			return;
		Meteo oldmeteo = this.meteo;
		this.meteo = null;
		oldmeteo.unsetSeance();	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removePersonne(Personne oldPersonne) {
		if(this.personne == null)
			return;
		
		if (this.personne.remove(oldPersonne))
			oldPersonne.removeSeance(this);
			
	}
	
}

