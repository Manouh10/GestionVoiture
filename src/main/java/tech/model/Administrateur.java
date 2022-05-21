package tech.model;

import javax.persistence.*; 

@Entity
public class Administrateur {
    /**
	 * 
	 */ 
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id_administrateur;
    @Column(nullable = false, updatable = false)
    private String login;
    @Column(nullable = false, updatable = false)
    private String mot_de_passe;
    

    public Administrateur() {}


	public Administrateur(Long id_administrateur, String login, String mot_de_passe) {
		 
		this.id_administrateur = id_administrateur;
		this.login = login;
		this.mot_de_passe = mot_de_passe;
	}


	public Long getId_administrateur() {
		return id_administrateur;
	}


	public void setId_administrateur(Long id_administrateur) {
		this.id_administrateur = id_administrateur;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getMot_de_passe() {
		return mot_de_passe;
	}


	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}


	 

	 
     
}
