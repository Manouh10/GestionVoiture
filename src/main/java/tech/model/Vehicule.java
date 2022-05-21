package tech.model;

import javax.persistence.*; 

@Entity
public class Vehicule   {
    /**
	 * 
	 */ 
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id_vehicule;
    @Column(nullable = false, updatable = false)
    private String numero; 
    
    @Column(nullable = false, updatable = false)
    private String modele;
 
    @OneToOne
    @JoinColumn(name = "type_vehicule", referencedColumnName = "id_type_vehicule") 
    private Type_vehicule typvehicule;
    
    @OneToOne
    @JoinColumn(name = "marque",referencedColumnName = "id_marque")  
    private Marque marq;
    
    
    @Column(nullable = false, updatable = false)
    private int  kilometrage;
    
    
    public Vehicule() {} 
	  

	public Vehicule(Long id_vehicule, String numero, String modele, Type_vehicule typvehicule, Marque marq,
 int kilometrage) { 
		this.id_vehicule = id_vehicule;
		this.numero = numero;
		this.modele = modele;
		this.typvehicule = typvehicule;
		this.marq = marq;
		this.kilometrage = kilometrage; 
	}
 
	public Long getId_vehicule() {
		return id_vehicule;
	}

	public void setId_vehicule(Long id_vehicule) {
		this.id_vehicule = id_vehicule;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public Marque getMarq() {
		return marq;
	}

	public void setMarq(Marque marq) {
		this.marq = marq;
	}

	public Type_vehicule getTypvehicule() {
		return typvehicule;
	}

	public void setTypvehicule(Type_vehicule typvehicule) {
		this.typvehicule = typvehicule;
	}

	public int getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(int kilometrage) {
		this.kilometrage = kilometrage;
	}

    
}
