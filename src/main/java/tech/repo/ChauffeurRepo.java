package tech.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
import tech.model.Chauffeur;

import java.util.Optional;

public interface ChauffeurRepo extends JpaRepository<Chauffeur, Long> {

    //Optional<Super> findByNom_superAndMot_de_passe(String nom_super, String mot_de_passe);

    @Query(value="SELECT * FROM chauffeur WHERE email = :email AND mot_de_passe= :mot_de_passe ",nativeQuery=true)
    Optional<Chauffeur> findLogin(@Param("email") String email, @Param("mot_de_passe") String mot_de_passe); 
}
