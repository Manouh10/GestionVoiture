package tech.model;

import javax.persistence.*; 

@Entity
public class StockMatiere   {
    /**
	 * 
	 */ 
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id_stock_matiere;
    @Column(nullable = false, updatable = false)
    private int quantite;

    @OneToOne
    @JoinColumn(name = "matiere",referencedColumnName = "id_matiere")
    private Matiere matr;

    public StockMatiere() {}

    public StockMatiere(Long id_stock_matiere, int quantite, Matiere matr) {
        this.id_stock_matiere = id_stock_matiere;
        this.quantite = quantite;
        this.matr = matr;
    }

    public Long getId_stock_matiere() {
        return id_stock_matiere;
    }

    public void setId_stock_matiere(Long id_stock_matiere) {
        this.id_stock_matiere = id_stock_matiere;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Matiere getMatr() {
        return matr;
    }

    public void setMatr(Matiere matr) {
        this.matr = matr;
    }
}
