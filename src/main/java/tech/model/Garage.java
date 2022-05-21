package tech.model;
  
public class Garage   {
   
    private Long duree_echeance;
    private String numero ;
    private String modele ;
    private int marque;
    private String date_renouvellement;
    private int type_vehicule;
    private String date_echeance;
    private String nom_echeance; 
    private Long jour_restant;
    private String nom_type_vehicule; 
    private String nom_marque; 
    private String image; 
    
    public Garage() {}
	public Garage(Long duree_echeance, String numero, String modele, int marque, String date_renouvellement,
			int type_vehicule, String date_echeance, String nom_echeance, Long jour_restant, String nom_type_vehicule,
			String nom_marque, String image) {
		super();
		this.duree_echeance = duree_echeance;
		this.numero = numero;
		this.modele = modele;
		this.marque = marque;
		this.date_renouvellement = date_renouvellement;
		this.type_vehicule = type_vehicule;
		this.date_echeance = date_echeance;
		this.nom_echeance = nom_echeance;
		this.jour_restant = jour_restant;
		this.nom_type_vehicule = nom_type_vehicule;
		this.nom_marque = nom_marque;
		this.image = image;
	}
	public Long getDuree_echeance() {
		return duree_echeance;
	}
	public void setDuree_echeance(Long duree_echeance) {
		this.duree_echeance = duree_echeance;
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
	public int getMarque() {
		return marque;
	}
	public void setMarque(int marque) {
		this.marque = marque;
	}
	public String getDate_renouvellement() {
		return date_renouvellement;
	}
	public void setDate_renouvellement(String date_renouvellement) {
		this.date_renouvellement = date_renouvellement;
	}
	public int getType_vehicule() {
		return type_vehicule;
	}
	public void setType_vehicule(int type_vehicule) {
		this.type_vehicule = type_vehicule;
	}
	public String getDate_echeance() {
		return date_echeance;
	}
	public void setDate_echeance(String date_echeance) {
		this.date_echeance = date_echeance;
	}
	public String getNom_echeance() {
		return nom_echeance;
	}
	public void setNom_echeance(String nom_echeance) {
		this.nom_echeance = nom_echeance;
	}
	public Long getJour_restant() {
		return jour_restant;
	}
	public void setJour_restant(Long jour_restant) {
		this.jour_restant = jour_restant;
	}
	public String getNom_type_vehicule() {
		return nom_type_vehicule;
	}
	public void setNom_type_vehicule(String nom_type_vehicule) {
		this.nom_type_vehicule = nom_type_vehicule;
	}
	public String getNom_marque() {
		return nom_marque;
	}
	public void setNom_marque(String nom_marque) {
		this.nom_marque = nom_marque;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	 
}
