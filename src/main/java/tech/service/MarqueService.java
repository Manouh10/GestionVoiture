package tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.model.Marque; 
import tech.repo.MarqueRepo;  

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MarqueService {
	@Autowired
    private  MarqueRepo marqueRepo; 
     
    public List<Marque> getAllMarque()
    {
        return  marqueRepo.findAll();
    }


}
