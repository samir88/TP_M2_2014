package org.samir;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;


@Entity(name="Commune")
@Table(name="commune")

public class Commune implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="Nom", length=40)
	private String nom;
	
	@Column(name="CodePostale", length=40)
	private String codePostale;
	
	@OneToOne
    private Maire maire ;
	
	@ManyToOne
    private Departement departement ;

	
	@Embedded
	private Adresse adresse = new Adresse();
	
	/*public Adresse getAdresse() {
		return Adresse.getAdresse(this.adresse);
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}*/
	
	
	public Maire getMaire() {
		return maire;
	}
	public void setMaire(Maire maire) {
		this.maire = maire;
	}

	private static final long serialVersionUID = 1L;

	public Commune() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getCodePostale() {
		return this.codePostale;
	}

	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	@Override
	public String toString() {
		return "Je suis la commune " + nom;
	}
   
	
	
}