package tp3;


/**
 * <br>
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

@javax.persistence.Entity
public class TypeSport
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	@javax.persistence.Column(nullable = true)
	protected String nom;
	
	
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
	public TypeSport(){
		super();
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
	public String getNom() {
		return this.nom;	
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
}

