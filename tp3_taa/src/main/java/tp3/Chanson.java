package tp3;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;


/**
 * <br>
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

@javax.persistence.Entity
public class Chanson
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@javax.persistence.Column(nullable = false)
	protected String nom;
	/**
	 * <br>
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@javax.persistence.Column(nullable = false)
	protected int duree;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@javax.persistence.ManyToMany(mappedBy = "chanson")
	protected Set<ListeChanson> listeChanson;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	@javax.persistence.Id
	@javax.persistence.Column(nullable = false)
	@GeneratedValue
	protected final Long id = 0L;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Chanson(){
		super();
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
	public int getDuree() {
		return this.duree;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Set<ListeChanson> getListeChanson() {
		if(this.listeChanson == null) {
				this.listeChanson = new HashSet<ListeChanson>();
		}
		return (Set<ListeChanson>) this.listeChanson;	
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
	public void addAllListeChanson(Set<ListeChanson> newListeChanson) {
		if (this.listeChanson == null) {
			this.listeChanson = new HashSet<ListeChanson>();
		}
		for (ListeChanson tmp : newListeChanson)
			tmp.addChanson(this);
			
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeAllListeChanson(Set<ListeChanson> newListeChanson) {
		if(this.listeChanson == null) {
			return;
		}
		
		this.listeChanson.removeAll(newListeChanson);	
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
	public void setDuree(int myDuree) {
		this.duree = myDuree;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addListeChanson(ListeChanson newListeChanson) {
		if(this.listeChanson == null) {
			this.listeChanson = new HashSet<ListeChanson>();
		}
		
		if (this.listeChanson.add(newListeChanson))
			newListeChanson.addChanson(this);	
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
	public void unsetDuree() {
		this.duree = 0;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeListeChanson(ListeChanson oldListeChanson) {
		if(this.listeChanson == null)
			return;
		
		if (this.listeChanson.remove(oldListeChanson))
			oldListeChanson.removeChanson(this);
			
	}
	
}

