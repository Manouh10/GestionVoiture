package tech.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; 
import  tech.model.StockMatiere; 

import java.util.List; 

public interface StockMatiereRepo extends JpaRepository<StockMatiere, Long> {

    @Query(value="select matiere,sum(quantite) as qte from stock_matiere group by matiere",nativeQuery=true)
       List<StockMatiere> getTest();
}
