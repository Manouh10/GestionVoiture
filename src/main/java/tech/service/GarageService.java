package tech.service;

 import org.springframework.stereotype.Service;

import connexion.Connexion;
import tech.model.Echeance;
import  tech.model.Garage; 

import javax.transaction.Transactional;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List; 

@Service
@Transactional
public class GarageService {
	 public  ArrayList<Garage> getAllGarage()  throws Exception
	    {
	        Connexion connex = new Connexion();
	        Connection con = connex.getConnection(); 
	        ArrayList<Garage> listGarage= new ArrayList<Garage>(); 
	        Statement stmt = con.createStatement(); 
	        ResultSet res = stmt.executeQuery("select * from garage");      
	        while(res.next())
	        {
	        	Garage g= new Garage(); 
	        	g.setModele(res.getString("modele"));
	        	g.setJour_restant(res.getLong("jour_restant"));
	        	g.setNom_marque(res.getString("nom_marque"));
	        	g.setNom_type_vehicule(res.getString("nom_type_vehicule"));  
	        	g.setDate_renouvellement(res.getString("date_renouvellement"));
	            g.setNom_echeance(res.getString("nom_echeance")); 
	            g.setDate_echeance(res.getString("date_echeance"));
	            g.setDuree_echeance(res.getLong("duree_echeance"));
	            listGarage.add(g);
	        }
	        con.close();
	        return listGarage;
	    }
	 public static String getColor(Garage e)
     {
		 String retour="";
		 if(e.getJour_restant()<15)
    	 {
    		 retour="rouge.png";
    	 }
    	 if((e.getJour_restant()>=15)&&(e.getJour_restant()<30))
    	 {
    		 retour="jaune.png";
    	 } 
    	 if(e.getJour_restant()>=30) {retour="blanc.png";}
    	 return retour;
     }
     
     public List<Garage> getListEcheance_with_Color(List<Garage> le)
     { 
    	 for(int i=0;i<le.size();i++)
    	 {
    		 le.get(i).setNumero(getColor(le.get(i))); 
    	 }
    	 return le;
     }
}
