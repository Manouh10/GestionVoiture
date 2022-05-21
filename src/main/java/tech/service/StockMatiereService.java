package tech.service;
 
import org.springframework.stereotype.Service;
import  tech.model.Matiere;
import  tech.model.StockMatiere; 
import  tech.repo.StockMatiereRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StockMatiereService {
    private  StockMatiereRepo stockMatiereRepo;

    public StockMatiere insertMatiere(StockMatiere matiere,Long idMatiere)
    {
        matiere.setMatr(new Matiere(idMatiere,null,null));
        return stockMatiereRepo.save(matiere);
    }
    public List<StockMatiere> getAllStockMatiere()
    {
        return stockMatiereRepo.findAll();
    }

    public List<StockMatiere> getTest(){return stockMatiereRepo.getTest();}
}
