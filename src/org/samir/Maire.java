package org.samir;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity(name="Maire")
@Table(name="maire")

public class Maire implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="Nom", length=40)
	private String nom;
	
	@OneToOne(mappedBy="maire")  
	private Commune commune ;
	
	private static final long serialVersionUID = 1L;

	
	@Embedded
	private Adresse adresse = new Adresse();
	
	public Adresse getAdresse() {
		return Adresse.getAdresse(this.adresse);
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	

	
	public Maire() {
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
	public Commune getCommune() {
		return commune;
	}
	public void setCommune(Commune commune) {
		this.commune = commune;
	}
	@Override
	public String toString() {
		return "Je suis " + nom + ", maire de la commune de " + commune+"\n";
	}
	
	
}