package tp3;



/**
 * <br>
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

@javax.persistence.Entity
public class Meteo
{
	public static final String[] tempsLibelles = {
		"Soleil",
		"Nuage",
		"Brouillard",
		"Pluie légère",
		"Pluie forte",
		"Orage",
		"Apocalypse"
	};
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@javax.persistence.OneToOne(mappedBy = "meteo")
	protected Seance seance;
	

	@javax.persistence.Column(nullable = true)
	protected String temps;

	@javax.persistence.Column(nullable = true)
	protected int temperature;

	@javax.persistence.Column(nullable = true)
	protected int vent;

	@javax.persistence.Column(nullable = true)
	protected int uv;
	
	
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
	public Meteo(){
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void basicSetSeance(Seance mySeance) {
		if (this.seance != mySeance) {
			if (mySeance != null){
				if (this.seance != mySeance) {
					Seance oldseance = this.seance;
					this.seance = mySeance;
					if (oldseance != null)
						oldseance.unsetMeteo();
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
	public Seance getSeance() {
		return this.seance;	
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
	public void setSeance(Seance mySeance) {
		this.basicSetSeance(mySeance);
		mySeance.basicSetMeteo(this);
			
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetSeance() {
		if (this.seance == null)
			return;
		Seance oldseance = this.seance;
		this.seance = null;
		oldseance.unsetMeteo();	
	}

	
	
	public String getTemps() {
		return temps;
	}

	public void setTemps(String temps) {
		this.temps = temps;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getVent() {
		return vent;
	}

	public void setVent(int vent) {
		this.vent = vent;
	}

	public int getUv() {
		return uv;
	}

	public void setUv(int uv) {
		this.uv = uv;
	}
	
}

