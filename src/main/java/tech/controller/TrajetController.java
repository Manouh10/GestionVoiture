package tech.controller;
 
 
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.RequestParam;

import tech.model.Trajet; 
import tech.service.TrajetService; 
 
/**
 * TrajetController
 */
@Controller 
public class TrajetController {

     
	@Autowired
    private TrajetService trajetService; 
	
	 @PostMapping ("/insertTrajet")
	    public String insertTrajet(@ModelAttribute Trajet trajet, @RequestParam("vehicule") Long id_vehicule, @RequestParam("chauffeur") Long id_chauffeur)
	    {
		 if((trajet.getKilometrage_arrivee()<0)||(trajet.getKilometrage_depart()<0))
		 {
			return "redirect:page_trajet?error=1";
		 }
			 
		 trajetService.insertTrajet(trajet, id_vehicule, id_chauffeur);
	        return "redirect:page_trajet";
	    } 


}