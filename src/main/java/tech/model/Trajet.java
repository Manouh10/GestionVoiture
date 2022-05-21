package tech.model;

import javax.persistence.*; 

@Entity
public class Trajet   {
    /**
	 * 
	 */ 
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id_trajet;
    @Column(nullable = false, updatable = false)
    private String motif; 
    
    @Column(nullable = false, updatable = false)
    private int quantite;
    
    @Column(nullable = false, updatable = false)
    private String date_depart; 
    
    @Column(nullable = false, updatable = false)
    private String heure_depart; 
    
    @Column(nullable = false, updatable = false)
    private String lieu_depart;  
 
    @Column(nullable = false, updatable = false)
    private int kilometrage_depart;
    
    @Column(nullable = false, updatable = false)
    private String date_arrivee; 
    
    @Column(nullable = false, updatable = false)
    private String heure_arrivee; 
    
    @Column(nullable = false, updatable = false)
    private String lieu_arrivee;  
 
    @Column(nullable = false, updatable = false)
    private int kilometrage_arrivee;
    
    @OneToOne
    @JoinColumn(name = "chauffeur",referencedColumnName = "id_chauffeur")  
    private Chauffeur chauff;
    
    @OneToOne
    @JoinColumn(name = "vehicule",referencedColumnName = "id_vehicule")  
    private Vehicule vehc;
    
     
    public Trajet() {}


	public Trajet(Long id_trajet, String motif, int quantite, String date_depart, String heure_depart,
			String lieu_depart, int kilometrage_depart, String date_arrivee, String heure_arrivee, String lieu_arrivee,
			int kilometrage_arrivee, Chauffeur chauff, Vehicule vehc) {
		super();
		this.id_trajet = id_trajet;
		this.motif = motif;
		this.quantite = quantite;
		this.date_depart = date_depart;
		this.heure_depart = heure_depart;
		this.lieu_depart = lieu_depart;
		this.kilometrage_depart = kilometrage_depart;
		this.date_arrivee = date_arrivee;
		this.heure_arrivee = heure_arrivee;
		this.lieu_arrivee = lieu_arrivee;
		this.kilometrage_arrivee = kilometrage_arrivee;
		this.chauff = chauff;
		this.vehc = vehc;
	}


	public Long getId_trajet() {
		return id_trajet;
	}


	public void setId_trajet(Long id_trajet) {
		this.id_trajet = id_trajet;
	}


	public String getMotif() {
		return motif;
	}


	public void setMotif(String motif) {
		this.motif = motif;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public String getDate_depart() {
		return date_depart;
	}


	public void setDate_depart(String date_depart) {
		this.date_depart = date_depart;
	}


	public String getHeure_depart() {
		return heure_depart;
	}


	public void setHeure_depart(String heure_depart) {
		this.heure_depart = heure_depart;
	}


	public String getLieu_depart() {
		return lieu_depart;
	}


	public void setLieu_depart(String lieu_depart) {
		this.lieu_depart = lieu_depart;
	}


	public int getKilometrage_depart() {
		return kilometrage_depart;
	}


	public void setKilometrage_depart(int kilometrage_depart) {
		this.kilometrage_depart = kilometrage_depart;
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


	public String getLieu_arrivee() {
		return lieu_arrivee;
	}


	public void setLieu_arrivee(String lieu_arrivee) {
		this.lieu_arrivee = lieu_arrivee;
	}


	public int getKilometrage_arrivee() {
		return kilometrage_arrivee;
	}


	public void setKilometrage_arrivee(int kilometrage_arrivee) {
		this.kilometrage_arrivee = kilometrage_arrivee;
	}


	public Chauffeur getChauff() {
		return chauff;
	}


	public void setChauff(Chauffeur chauff) {
		this.chauff = chauff;
	}


	public Vehicule getVehc() {
		return vehc;
	}


	public void setVehc(Vehicule vehc) {
		this.vehc = vehc;
	}

	 
}
