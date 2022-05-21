package tech.model;
  
public class VoitureDispo   {
   
    
    private String modele ; 
    private String nom_marque;  
    private String date_arrivee;
    private String heure_arrivee;
    
     public VoitureDispo() {}

	public VoitureDispo(String modele, String nom_marque, String date_arrivee, String heure_arrivee) {
		super();
		this.modele = modele;
		this.nom_marque = nom_marque;
		this.date_arrivee = date_arrivee;
		this.heure_arrivee = heure_arrivee;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getNom_marque() {
		return nom_marque;
	}

	public void setNom_marque(String nom_marque) {
		this.nom_marque = nom_marque;
	}

	public String getDate_arrivee() {
		return date_arrivee;
	}

	public void setDate_arrivee(String date_arrivee) {
		this.date_arrivee = date_arrivee;
	}

	public String getHeure_arrivee() {
		return heure_arrivee;
	}

	public void setHeure_arrivee(String heure_arrivee) {
		this.heure_arrivee = heure_arrivee;
	}
	 
}
