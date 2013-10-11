package tp3;
import java.util.Set;
import java.util.HashSet;


/**
 * <br>
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

@javax.persistence.Entity
public class Parcours
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@javax.persistence.OneToOne
	protected Personne champion;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@javax.persistence.ManyToMany(mappedBy = "parcours")
	protected Set<PointGPS> pointGPS;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	@javax.persistence.Id
	@javax.persistence.Column(nullable = false)
	protected final Long id = 0L;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Parcours(){
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
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
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Personne getChampion() {
		return this.champion;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Set<PointGPS> getPointGPS() {
		if(this.pointGPS == null) {
				this.pointGPS = new HashSet<PointGPS>();
		}
		return (Set<PointGPS>) this.pointGPS;	
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
	public void addAllPointGPS(Set<PointGPS> newPointGPS) {
		if (this.pointGPS == null) {
			this.pointGPS = new HashSet<PointGPS>();
		}
		for (PointGPS tmp : newPointGPS)
			tmp.addParcours(this);
			
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeAllPointGPS(Set<PointGPS> newPointGPS) {
		if(this.pointGPS == null) {
			return;
		}
		
		this.pointGPS.removeAll(newPointGPS);	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setChampion(Personne myChampion) {
		this.basicSetChampion(myChampion);
		myChampion.basicSetParcours(this);
			
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addPointGPS(PointGPS newPointGPS) {
		if(this.pointGPS == null) {
			this.pointGPS = new HashSet<PointGPS>();
		}
		
		if (this.pointGPS.add(newPointGPS))
			newPointGPS.addParcours(this);	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetChampion() {
		if (this.champion == null)
			return;
		Personne oldchampion = this.champion;
		this.champion = null;
		oldchampion.unsetParcours();	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removePointGPS(PointGPS oldPointGPS) {
		if(this.pointGPS == null)
			return;
		
		if (this.pointGPS.remove(oldPointGPS))
			oldPointGPS.removeParcours(this);
			
	}
	
}

