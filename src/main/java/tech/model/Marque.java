package tech.model;

import javax.persistence.*; 

@Entity
public class Marque   {
    /**
	 * 
	 */ 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(nullable = false, updatable = false)
    private Long id_marque;
    @Column(nullable = false, updatable = false)
    private String nom_marque;
     
    @Column(nullable = false, updatable = false)
    private String image; 

    public Marque() {}

	 
	public Marque(Long id_marque, String nom_marque, String image) {
		super();
		this.id_marque = id_marque;
		this.nom_marque = nom_marque;
		this.image = image;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Long getId_marque() {
		return id_marque;
	}

	public void setId_marque(Long id_marque) {
		this.id_marque = id_marque;
	}

	public String getNom_marque() {
		return nom_marque;
	}

	public void setNom_marque(String nom_marque) {
		this.nom_marque = nom_marque;
	}

	 

   
}
