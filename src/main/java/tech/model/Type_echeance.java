package tech.model;

import javax.persistence.*; 

@Entity
public class Type_echeance {
    /**
	 * 
	 */ 
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id_type_echeance;
    @Column(nullable = false, updatable = false)
    private String nom_echeance;
    @Column(nullable = false, updatable = false)
    private int duree_echeance;
     

    public Type_echeance() {}


	public Type_echeance(Long id_type_echeance, String nom_echeance, int duree_echeance) {
		super();
		this.id_type_echeance = id_type_echeance;
		this.nom_echeance = nom_echeance;
		this.duree_echeance = duree_echeance;
	}


	public Long getId_type_echeance() {
		return id_type_echeance;
	}


	public void setId_type_echeance(Long id_type_echeance) {
		this.id_type_echeance = id_type_echeance;
	}


	public String getNom_echeance() {
		return nom_echeance;
	}


	public void setNom_echeance(String nom_echeance) {
		this.nom_echeance = nom_echeance;
	}


	public int getDuree_echeance() {
		return duree_echeance;
	}


	public void setDuree_echeance(int duree_echeance) {
		this.duree_echeance = duree_echeance;
	} 
 
}
