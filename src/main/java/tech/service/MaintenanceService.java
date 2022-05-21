package tech.service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.model.Maintenance; 
import tech.model.Type_maintenance; 
import tech.model.Vehicule;
import tech.repo.MaintenanceRepo; 

import java.util.List;

import javax.transaction.Transactional; 

@Service
@Transactional
public class MaintenanceService {
	@Autowired
    private  MaintenanceRepo maintenanceRepo;

    public Maintenance insertMaintenance(Maintenance maintenance,Long id_type_maintenance,Long id_vehicule)
    { 
    	Type_maintenance m= new Type_maintenance();
    	Vehicule v= new Vehicule();
    	m.setId_type_maintenance(id_type_maintenance);
    	v.setId_vehicule(id_vehicule);
    	maintenance.setTypm(m); maintenance.setVehc(v); 
        return maintenanceRepo.save(maintenance);
    }
    
    public List<Maintenance> getAllMaintenance()
    {
    	return maintenanceRepo.findAll();
    }
    
}
