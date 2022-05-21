package tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import tech.model.Type_vehicule; 
import tech.repo.Type_vehiculeRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class Type_vehiculeService {
	@Autowired
    private  Type_vehiculeRepo type_vehiculeRepo; 
     
    public List<Type_vehicule> getAllType_vehicule()
    {
        return  type_vehiculeRepo.findAll();
    }


}
