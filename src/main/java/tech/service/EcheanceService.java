package tech.service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
import tech.model.Type_echeance; 
import tech.model.Vehicule;
import tech.model.Echeance;
import tech.repo.EcheanceRepo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional; 

@Service
@Transactional
public class EcheanceService {
	@Autowired
    private  EcheanceRepo echeanceRepo;

    public Echeance insertEcheance(Echeance echeance,Long id_type_echeance,Long id_vehicule)
    { 
    	Type_echeance t = new Type_echeance();
    	Vehicule v= new Vehicule();
    	t.setId_type_echeance(id_type_echeance);
    	v.setId_vehicule(id_vehicule);
    	echeance.setTypech(t);
    	echeance.setVehc(v); 
        return echeanceRepo.save(echeance);
    }
     public String getDate_echeance(String date_renouvellement,int duree_echeance) throws ParseException
     {
    	 SimpleDateFormat sd= new SimpleDateFormat("yyyy-dd-mm");
    	 Calendar c= Calendar.getInstance();
    	 c.setTime(sd.parse(date_renouvellement));
    	 c.add(Calendar.DAY_OF_MONTH,duree_echeance);
    	 return sd.format(c.getTime());
     }
    
     
      
    
    
    
}
