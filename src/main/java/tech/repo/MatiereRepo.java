package tech.repo;

import org.springframework.data.jpa.repository.JpaRepository;
 
import  tech.model.Matiere; 

public interface MatiereRepo extends JpaRepository<Matiere, Long> {


}
