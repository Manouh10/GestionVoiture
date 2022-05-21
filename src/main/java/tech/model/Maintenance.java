package tech.model;

import javax.persistence.*; 

@Entity
public class Maintenance {
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id_maintenance;
	
	@OneToOne
    @JoinColumn(name = "type_maintenance",referencedColumnName = "id_type_maintenance")  
    private Type_maintenance typm;
	
	@OneToOne
    @JoinColumn(name = "vehicule",referencedColumnName = "id_vehicule")  
    private Vehicule vehc;
    
    public Maintenance() {}

	public Maintenance(Long id_maintenance, Type_maintenance typm, Vehicule vehc) {
		super();
		this.id_maintenance = id_maintenance;
		this.typm = typm;
		this.vehc = vehc;
	}

	public Long getId_maintenance() {
		return id_maintenance;
	}

	public void setId_maintenance(Long id_maintenance) {
		this.id_maintenance = id_maintenance;
	}

	public Type_maintenance getTypm() {
		return typm;
	}

	public void setTypm(Type_maintenance typm) {
		this.typm = typm;
	}

	public Vehicule getVehc() {
		return vehc;
	}

	public void setVehc(Vehicule vehc) {
		this.vehc = vehc;
	} 

	 
	 
}
