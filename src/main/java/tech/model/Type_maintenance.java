package tech.model;

import javax.persistence.*; 

@Entity
public class Type_maintenance   {
    /**
	 * 
	 */ 
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id_type_maintenance;
    @Column(nullable = false, updatable = false)
    private String nom_type_maintenance; 
    
    @Column(nullable = false, updatable = false)
    private int valable;
  
    public Type_maintenance() {}

	public Type_maintenance(Long id_type_maintenance, String nom_type_maintenance, int valable) {
		super();
		this.id_type_maintenance = id_type_maintenance;
		this.nom_type_maintenance = nom_type_maintenance;
		this.valable = valable;
	}

	public Long getId_type_maintenance() {
		return id_type_maintenance;
	}

	public void setId_type_maintenance(Long id_type_maintenance) {
		this.id_type_maintenance = id_type_maintenance;
	}

	public String getNom_type_maintenance() {
		return nom_type_maintenance;
	}

	public void setNom_type_maintenance(String nom_type_maintenance) {
		this.nom_type_maintenance = nom_type_maintenance;
	}

	public int getValable() {
		return valable;
	}

	public void setValable(int valable) {
		this.valable = valable;
	} 
	  
 
}
