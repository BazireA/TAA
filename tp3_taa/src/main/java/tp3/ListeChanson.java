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
public class ListeChanson
{
	/**
	 * <br>
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@javax.persistence.Column(nullable = false)
	protected String nom;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@javax.persistence.OneToMany(mappedBy = "listeChanson")
	protected Set<Seance> seance;
	/**
	 * <br>
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@javax.persistence.ManyToMany(cascade=CascadeType.PERSIST)
	protected Set<Chanson> chanson;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	@javax.persistence.Id
	@javax.persistence.Column(nullable = false)
	@javax.persistence.GeneratedValue
	protected final Long id = 0L;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public ListeChanson(){
		super();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public ListeChanson(String nom){
		super();
		this.nom = nom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public String getNom() {
		return this.nom;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Set<Seance> getSeance() {
		if(this.seance == null) {
				this.seance = new HashSet<Seance>();
		}
		return (Set<Seance>) this.seance;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Set<Chanson> getChanson() {
		if(this.chanson == null) {
				this.chanson = new HashSet<Chanson>();
		}
		return (Set<Chanson>) this.chanson;	
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
	public void addAllSeance(Set<Seance> newSeance) {
		if (this.seance == null) {
			this.seance = new HashSet<Seance>();
		}
		for (Seance tmp : newSeance)
			tmp.setListeChanson(this);
			
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addAllChanson(Set<Chanson> newChanson) {
		if (this.chanson == null) {
			this.chanson = new HashSet<Chanson>();
		}
		for (Chanson tmp : newChanson)
			tmp.addListeChanson(this);
			
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeAllSeance(Set<Seance> newSeance) {
		if(this.seance == null) {
			return;
		}
		
		this.seance.removeAll(newSeance);	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeAllChanson(Set<Chanson> newChanson) {
		if(this.chanson == null) {
			return;
		}
		
		this.chanson.removeAll(newChanson);	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setNom(String myNom) {
		this.nom = myNom;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addSeance(Seance newSeance) {
		if(this.seance == null) {
			this.seance = new HashSet<Seance>();
		}
		
		if (this.seance.add(newSeance))
			newSeance.basicSetListeChanson(this);	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addChanson(Chanson newChanson) {
		if(this.chanson == null) {
			this.chanson = new HashSet<Chanson>();
		}
		
		if (this.chanson.add(newChanson))
			newChanson.addListeChanson(this);	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetNom() {
		this.nom = "";	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeSeance(Seance oldSeance) {
		if(this.seance == null)
			return;
		
		if (this.seance.remove(oldSeance))
			oldSeance.unsetListeChanson();
			
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeChanson(Chanson oldChanson) {
		if(this.chanson == null)
			return;
		
		if (this.chanson.remove(oldChanson))
			oldChanson.removeListeChanson(this);
			
	}
	
}

