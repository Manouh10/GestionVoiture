package tech.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.model.Maintenance; 

public interface MaintenanceRepo extends JpaRepository<Maintenance, Long> {


}
