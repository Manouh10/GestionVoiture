package tech.model;

import javax.persistence.*; 

@Entity
public class Chauffeur {
    /**
	 * 
	 */ 
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id_chauffeur;
    @Column(nullable = false, updatable = false)
    private String nom_chauffeur;
    @Column(nullable = false, updatable = false)
    private String email;
    @Column(nullable = false, updatable = false)
    private String mot_de_passe; 

    public Chauffeur() {} 

	public Chauffeur(Long id_chauffeur, String nom_chauffeur, String email, String mot_de_passe) {
	 
		this.id_chauffeur = id_chauffeur;
		this.nom_chauffeur = nom_chauffeur;
		this.email = email;
		this.mot_de_passe = mot_de_passe; 
	} 
	
	public Long getId_chauffeur() {
		return id_chauffeur;
	}

	public void setId_chauffeur(Long id_chauffeur) {
		this.id_chauffeur = id_chauffeur;
	}

	public String getNom_chauffeur() {
		return nom_chauffeur;
	}

	public void setNom_chauffeur(String nom_chauffeur) {
		this.nom_chauffeur = nom_chauffeur;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

	 
}
