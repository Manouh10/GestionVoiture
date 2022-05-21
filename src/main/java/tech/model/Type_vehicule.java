package tech.model;

import javax.persistence.*; 

@Entity
public class Type_vehicule   {
    /**
	 * 
	 */ 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(nullable = false, updatable = false)
    private Long id_type_vehicule;
    @Column(nullable = false, updatable = false)
    private String nom_type_vehicule;
     

    public Type_vehicule() {}


	public Type_vehicule(Long id_type_vehicule, String nom_type_vehicule) {
		super();
		this.id_type_vehicule = id_type_vehicule;
		this.nom_type_vehicule = nom_type_vehicule;
	}


	public Long getId_type_vehicule() {
		return id_type_vehicule;
	}


	public void setId_type_vehicule(Long id_type_vehicule) {
		this.id_type_vehicule = id_type_vehicule;
	}


	public String getNom_type_vehicule() {
		return nom_type_vehicule;
	}


	public void setNom_type_vehicule(String nom_type_vehicule) {
		this.nom_type_vehicule = nom_type_vehicule;
	}

	 
}
