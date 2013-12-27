package tp3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonIgnore;


@Entity
public class Meteo
{
	public static final String[][] tempsLibelles = {
		{"1", "Soleil"},
		{"2", "Nuage"},
		{"3", "Brouillard"},
		{"4", "Pluie légère"},
		{"5", "Pluie forte"},
		{"6", "Orage"},
		{"7", "Apocalypse"}
	};

	
	/******************************************************************\
	 * Attributs
	\******************************************************************/
	@Id
	@Column(nullable = false)
	@GeneratedValue
	protected final Long id = 0L;

	@Column(nullable = true)
	protected String temps;

	@Column(nullable = true)
	protected int temperature;

	@Column(nullable = true)
	protected int vent;

	@Column(nullable = true)
	protected int uv;
	
	@OneToOne(mappedBy = "meteo")
	protected Seance seance;
	/******************************************************************/
	
	
	
	
	/******************************************************************\
	 * Constructeur
	\******************************************************************/
	public Meteo() {
		super();
	}
	/******************************************************************/

	
	
	/******************************************************************\
	 * 
	\******************************************************************/
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
	/******************************************************************/
	
	
	
	
	/******************************************************************\
	 * Getters
	\******************************************************************/
	public long getId() { return this.id; }
	public String getTemps() { return temps; }
	public int getTemperature() { return temperature; }
	public int getVent() { return vent; }
	public int getUv() { return uv; }
	@JsonIgnore
	public Seance getSeance() { return seance; }
	/******************************************************************/
	
	
	
	
	/******************************************************************\
	 * Setters
	\******************************************************************/
	public void setTemps(String temps) {
		this.temps = temps;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public void setVent(int vent) {
		this.vent = vent;
	}

	public void setUv(int uv) {
		this.uv = uv;
	}

	public void setSeance(Seance mySeance) {
		this.basicSetSeance(mySeance);
		mySeance.basicSetMeteo(this);
	}
	
	public void unsetSeance() {
		if (this.seance == null)
			return;
		Seance oldseance = this.seance;
		this.seance = null;
		oldseance.unsetMeteo();	
	}
	/******************************************************************/
}

