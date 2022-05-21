package tech.repo;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
import tech.model.Trajet;
 

public interface TrajetRepo extends JpaRepository<Trajet, Long> {

	@Query(value="SELECT * FROM trajet WHERE vehicule = :vehicule ",nativeQuery=true)
    List<Trajet> findTrajetById(@Param("vehicule") Long vehicule );

}
