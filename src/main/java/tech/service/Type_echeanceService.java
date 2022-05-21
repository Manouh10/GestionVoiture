package tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.model.Type_echeance; 
import tech.repo.Type_echeanceRepo; 

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class Type_echeanceService {
	@Autowired
    private  Type_echeanceRepo echeanceRepo;
     
    public List<Type_echeance> getAllType_echeance()
    {
        return  echeanceRepo.findAll();
    }


}
