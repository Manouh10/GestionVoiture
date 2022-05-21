package tech.service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.model.Marque; 
import tech.model.Type_vehicule;
import tech.model.Vehicule; 
import tech.repo.VehiculeRepo;

import java.util.List;

import javax.transaction.Transactional; 

@Service
@Transactional
public class VehiculeService {
	@Autowired
    private  VehiculeRepo vehiculeRepo;

    public Vehicule insertVehicule(Vehicule vehicule,Long id_marque,Long id_type_vehicule)
    { 
    	Marque m= new Marque();
    	Type_vehicule t= new Type_vehicule();
    	m.setId_marque(id_marque); 
    	t.setId_type_vehicule(id_type_vehicule);
    	vehicule.setMarq(m);
    	vehicule.setTypvehicule(t);
        return vehiculeRepo.save(vehicule);
    }
    
    public List<Vehicule> getAllVehicule()
    {
    	return vehiculeRepo.findAll();
    }
    
}
