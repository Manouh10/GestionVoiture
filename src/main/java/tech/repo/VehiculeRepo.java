package tech.repo;

import org.springframework.data.jpa.repository.JpaRepository; 
import tech.model.Vehicule;
 

public interface VehiculeRepo extends JpaRepository<Vehicule, Long> {

    
}
