package tech.service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import connexion.Connexion;
import tech.model.Chauffeur;
import tech.model.Garage;
import tech.model.Trajet; 
import tech.model.Vehicule;
import tech.repo.TrajetRepo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional; 

@Service
@Transactional
public class TrajetService {
	@Autowired
    private  TrajetRepo trajetRepo;

    public Trajet insertTrajet(Trajet trajet,Long id_vehicule,Long id_chauffeur)
    {  
    	trajet.setChauff(new Chauffeur(id_chauffeur,null,null,null));
    	Vehicule v= new Vehicule();
    	v.setId_vehicule(id_vehicule);
    	trajet.setVehc(v);
        return trajetRepo.save(trajet);
    }
    
    public List<Trajet> getAllTrajetById(Long vehicule)
    {
    	return trajetRepo.findTrajetById(vehicule);
    } 
    
    public static Long getLastKilometrage(Long vehicule) throws Exception  
    {
        Connexion connex = new Connexion();
        Connection con = connex.getConnection(); 
        Long retour=Long.valueOf(0); 
        Statement stmt = con.createStatement(); 
        ResultSet res = stmt.executeQuery("select max(kilometrage_arrivee) from trajet where vehicule="+vehicule+"");      
        while(res.next())
        {
        	 retour=res.getLong("max(kilometrage_arrivee)");
        }
        con.close();
        return retour;
    }
    
    public int TestKilometrage(Long new_kilometrage_depart,Long vehicule) throws Exception
    {
    	int retour=5;
    	if((new_kilometrage_depart<=getLastKilometrage(vehicule))||(new_kilometrage_depart<0)   )
    			{
    				retour=1;
    			}
    	else {retour=2;}
    	return retour;
    }
    public Long getVitesseMoyenne(Trajet t) throws ParseException
    {
    	SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
    	//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a"); 
    	
    	Long retour=Long.valueOf(5);
    	Date d_depart = sdf.parse(""+t.getDate_depart()+" "+t.getHeure_depart()+"");
    	Date d_arrivee = sdf.parse(""+t.getDate_arrivee()+" "+t.getHeure_arrivee()+"");
    	long differenceInHours = Math.abs(d_depart.getTime() - d_arrivee.getTime()) / 1000 / 60 / 60;
    	return retour;
    }
    public int testDateHeure(Trajet t)
    {
    	int retour=0;
    	
    	return retour;
    }
    
}
