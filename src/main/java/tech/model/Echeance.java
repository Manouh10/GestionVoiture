package tech.model;

import javax.persistence.*; 

@Entity
public class Echeance {
    /**
	 * 
	 */ 
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id_echeance;
    @Column(nullable = false, updatable = false)
    private String date_renouvellement;
    
    @OneToOne
    @JoinColumn(name = "type_echeance",referencedColumnName = "id_type_echeance") 
    private Type_echeance typech;
     
    @OneToOne
    @JoinColumn(name = "vehicule",referencedColumnName = "id_vehicule") 
    private Vehicule vehc;

    public Echeance() {}

	 

	public Echeance(Long id_echeance, String date_renouvellement, Type_echeance typech, Vehicule vehc) {
		super();
		this.id_echeance = id_echeance;
		this.date_renouvellement = date_renouvellement;
		this.typech = typech;
		this.vehc = vehc;
	}



	public Long getId_echeance() {
		return id_echeance;
	}

	public void setId_echeance(Long id_echeance) {
		this.id_echeance = id_echeance;
	}

	public String getDate_renouvellement() {
		return date_renouvellement;
	}

	public void setDate_renouvellement(String date_renouvellement) {
		this.date_renouvellement = date_renouvellement;
	}

	 

	public Type_echeance getTypech() {
		return typech;
	}



	public void setTypech(Type_echeance typech) {
		this.typech = typech;
	}



	public Vehicule getVehc() {
		return vehc;
	}

	public void setVehc(Vehicule vehc) {
		this.vehc = vehc;
	} 
	 
}
