package org.samir;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="Departement")
@Table(name="departement")

public class Departement implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="Nom", length=40)
	private String nom;
	
	@OneToMany (mappedBy = "departement", cascade=CascadeType.PERSIST, orphanRemoval = true)
	private List<Commune> listeCommunes=new ArrayList<Commune>();
    
	 public void addCommune(Commune c) {
			listeCommunes.add(c) ;	
	}
  
	public List getCommunes(){
		return this.listeCommunes;
	/*  //On fait une copie de la liste pour utiliser le pattern defensive copy
	 
	 	List<Commune> copieListe = new ArrayList<Commune>();
		Collections.copy(copieListe,this.listeCommunes);
		return copieListe;
	*/
	}
	
	public  Maire getMaire(Commune commune){
		return commune.getMaire();
	}
	
	@SuppressWarnings("unchecked")
	public List<Maire> getMaires(){
		
		List<Maire> listeMaires = new ArrayList<Maire>();
		List<Commune> listeCommunes = new ArrayList<Commune>();
		listeCommunes= this.getCommunes();
		
		
		for (Commune c : listeCommunes) {
			   listeMaires.add(c.getMaire()) ;
			}
		
		/*  //Pour le pattern defensive copy
		 List<Maire> copieListeMaires = new ArrayList<Maire>();
		 Collections.copy(copieListeMaires,this.liste);
		 return copieListeMaires;
		 */
		
		return listeMaires;
	}
	 
	
	private static final long serialVersionUID = 1L;

	public Departement() {
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
}