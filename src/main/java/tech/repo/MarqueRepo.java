package tech.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.model.Marque; 

public interface MarqueRepo extends JpaRepository<Marque, Long> {


}
