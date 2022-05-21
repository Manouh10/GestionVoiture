package tech.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tech.model.Administrateur; 

import java.util.Optional;

public interface AdministrateurRepo extends JpaRepository<Administrateur, Long> {

    //Optional<Super> findByNom_superAndMot_de_passe(String nom_super, String mot_de_passe);

    @Query(value="SELECT * FROM administrateur WHERE login = :login AND mot_de_passe= :mot_de_passe ",nativeQuery=true)
    Optional<Administrateur> findLogin(@Param("login") String login, @Param("mot_de_passe") String mot_de_passe);


}
