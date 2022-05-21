package tech.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tech.model.Chauffeur;
import tech.model.Echeance; 

public interface EcheanceRepo extends JpaRepository<Echeance, Long> {

	 @Query(value="SELECT * FROM chauffeur WHERE email = :email AND mot_de_passe= :mot_de_passe ",nativeQuery=true)
	 Optional<Chauffeur> findLogin(@Param("email") String email, @Param("mot_de_passe") String mot_de_passe); 
	 
	 @Query(value="update echeance set type_echeance= :type_echeance , date_renouvellement= :date_renouvellement where vehicule= :vehicule",nativeQuery=true)
	 void updateEcheance(@Param("type_echeance") Long type_echeance,@Param("date_renouvellement") String date_renouvellement, @Param("vehicule") Long vehicule);

}
