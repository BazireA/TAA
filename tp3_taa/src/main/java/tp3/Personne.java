package tp3;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Personne
{
	/******************************************************************\
	 * Attributs
	\******************************************************************/
	@Id
	@Column(nullable = true)
	@GeneratedValue
	protected final Long id = 0L;
	
	@Column(nullable = true)
	protected String nom;
	
	@Column(nullable = true)
	protected String prenom;
	
	@Column(nullable = true)
	protected String compteFacebook;
	
	@Column(nullable = false)
	protected String adresseMail;
	
	@Column(nullable = false)
	protected String motDePasse;
	
	@OneToOne(mappedBy = "champion")
	protected Parcours parcours;
	
	@ManyToMany(mappedBy = "personne")
	protected Set<Seance> seance;
	
	@OneToMany
	@JoinTable
	protected Set<Personne> amis;
	/******************************************************************/


	
	
	/******************************************************************\
	 * Constructeur
	\******************************************************************/
	public Personne(){
		super();
	}
	/******************************************************************/
	
	
	
	
	/******************************************************************\
	 * 
	\******************************************************************/
	public void basicSetParcours(Parcours myParcours) {
		if (this.parcours != myParcours) {
			if (myParcours != null){
				if (this.parcours != myParcours) {
					Parcours oldparcours = this.parcours;
					this.parcours = myParcours;
					if (oldparcours != null)
						oldparcours.unsetChampion();
				}
			}
		}	
	}
	/******************************************************************/
	
	
	
	
	/******************************************************************\
	 * Getters
	\******************************************************************/
	public long getId() { return this.id; }
	public String getNom() { return this.nom; }
	public String getPrenom() { return this.prenom; }
	public String getCompteFacebook() { return this.compteFacebook; }
	public String getAdresseMail() { return this.adresseMail; }
	public String getMotDePasse() { return this.motDePasse; }
	public Parcours getParcours() { return this.parcours; }
	
	public Set<Seance> getSeance() {
		if(this.seance == null)
			this.seance = new HashSet<Seance>();

		return (Set<Seance>) this.seance;	
	}
	
	public Set<Personne> getAmis() {
		if(this.amis == null)
			this.amis = new HashSet<Personne>();

		return (Set<Personne>) this.amis;	
	}
	/******************************************************************/
	
	
	
	
	/******************************************************************\
	 * Setters
	\******************************************************************/
	public void setNom(String myNom) {
		this.nom = myNom;	
	}
	
	public void setPrenom(String myPrenom) {
		this.prenom = myPrenom;	
	}
	
	public void setCompteFacebook(String myCompteFacebook) {
		this.compteFacebook = myCompteFacebook;	
	}
	
	public void setAdresseMail(String myAdresseMail) {
		this.adresseMail = myAdresseMail;	
	}
	
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	public void setParcours(Parcours myParcours) {
		this.basicSetParcours(myParcours);
		myParcours.basicSetChampion(this);
	}

	
	public void addSeance(Seance newSeance) {
		if(this.seance == null)
			this.seance = new HashSet<Seance>();
		
		if (this.seance.add(newSeance))
			newSeance.addPersonne(this);	
	}
	
	public void removeSeance(Seance oldSeance) {
		if(this.seance == null)
			return;
		
		if (this.seance.remove(oldSeance))
			oldSeance.removePersonne(this);
	}
	
	
	public void addAllSeance(Set<Seance> newSeance) {
		if (this.seance == null)
			this.seance = new HashSet<Seance>();

		for (Seance tmp : newSeance)
			tmp.addPersonne(this);
	}
	
	public void removeAllSeance(Set<Seance> newSeance) {
		if(this.seance == null)
			return;
		
		this.seance.removeAll(newSeance);	
	}


	public void addAmis(Personne newAmis) {
		if(this.amis == null)
			this.amis = new HashSet<Personne>();
		
		this.amis.add(newAmis);	
	}
	
	public void removeAmis(Personne oldAmis) {
		if(this.amis == null)
			return;
		
		this.amis.remove(oldAmis);	
	}
	
	
	public void addAllAmis(Set<Personne> newAmis) {
		if (this.amis == null)
			this.amis = new HashSet<Personne>();

		this.amis.addAll(newAmis);	
	}

	public void removeAllAmis(Set<Personne> newAmis) {
		if(this.amis == null)
			return;
		
		this.amis.removeAll(newAmis);	
	}
	/******************************************************************/
	
	
	
	
	/******************************************************************\
	 * Unsetters
	\******************************************************************/
	public void unsetNom() {
		this.nom = "";	
	}
	
	
	public void unsetPrenom() {
		this.prenom = "";	
	}
	
	
	public void unsetCompteFacebook() {
		this.compteFacebook = "";	
	}
	
	
	public void unsetAdresseMail() {
		this.adresseMail = "";	
	}
	
	
	public void unsetMotDePasse() {
		this.motDePasse = "";
	}
	
	
	public void unsetParcours() {
		if (this.parcours == null)
			return;
		
		Parcours oldparcours = this.parcours;
		this.parcours = null;
		oldparcours.unsetChampion();	
	}
	/******************************************************************/
}

