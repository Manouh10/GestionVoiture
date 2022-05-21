package tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  tech.model.Matiere; 
import  tech.repo.MatiereRepo; 

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MatiereService {
    private  MatiereRepo matiereRepo;

    @Autowired
    public MatiereService(MatiereRepo matiereRepo) {
        this.matiereRepo = matiereRepo;
    }

    public List<Matiere> getAllMatiere()
    {
        return  matiereRepo.findAll();
    }


}
