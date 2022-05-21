package tech.model;

import javax.persistence.*; 

@Entity
public class Matiere   {
    /**
	 * 
	 */ 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(nullable = false, updatable = false)
    private Long id_matiere;
    @Column(nullable = false, updatable = false)
    private String nom_matiere;
    @Column(nullable = false, updatable = false)
    private String prix_kg;

    public Matiere() {}

    public Matiere(Long id_matiere, String nom_matiere, String prix_kg) {
        this.id_matiere = id_matiere;
        this.nom_matiere = nom_matiere;
        this.prix_kg = prix_kg;
    }

    public Long getId_matiere() {
        return id_matiere;
    }

    public void setId_matiere(Long id_matiere) {
        this.id_matiere = id_matiere;
    }

    public String getNom_matiere() {
        return nom_matiere;
    }

    public void setNom_matiere(String nom_matiere) {
        this.nom_matiere = nom_matiere;
    }

    public String getPrix_kg() {
        return prix_kg;
    }

    public void setPrix_kg(String prix_kg) {
        this.prix_kg = prix_kg;
    }
}
