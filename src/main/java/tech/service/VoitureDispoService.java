package tech.service;

 import org.springframework.stereotype.Service;

import connexion.Connexion;
import  tech.model.VoitureDispo; 

import javax.transaction.Transactional;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList; 

@Service
@Transactional
public class VoitureDispoService {
	 public  ArrayList<VoitureDispo> getAllVoitureDispo()  throws Exception
	    {
	        Connexion connex = new Connexion();
	        Connection con = connex.getConnection(); 
	        ArrayList<VoitureDispo> listVoiture= new ArrayList<VoitureDispo>(); 
	        Statement stmt = con.createStatement(); 
	        ResultSet res = stmt.executeQuery("select * from voitureDispo");      
	        while(res.next())
	        {
	        	VoitureDispo  v= new VoitureDispo ();
	        	v.setNom_marque(res.getString("nom_marque"));
	        	v.setModele(res.getString("modele"));
	        	v.setDate_arrivee(res.getString("date_arrivee"));
	        	v.setHeure_arrivee(res.getString("heure_arrivee"));
	        	listVoiture.add(v);
	        }
	        con.close();
	        return listVoiture;
	    }
}
