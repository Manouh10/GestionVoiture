package tech.service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.model.Maintenance;
import tech.model.Marque;
import tech.model.Type_maintenance;
import tech.model.Type_vehicule;
import tech.model.Vehicule;
import tech.repo.MaintenanceRepo;
import tech.repo.Type_maintenanceRepo;
import tech.repo.VehiculeRepo;

import java.util.List;

import javax.transaction.Transactional; 

@Service
@Transactional
public class Type_maintenanceService {
	@Autowired
    private  Type_maintenanceRepo maintenanceRepo;

     
    
    public List<Type_maintenance> getAllTypeMaintenance()
    {
    	return maintenanceRepo.findAll();
    }
    
}
