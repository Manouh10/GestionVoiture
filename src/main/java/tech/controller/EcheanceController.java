package tech.controller;
 

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tech.model.Echeance;
import tech.model.Type_echeance;
import tech.model.Type_maintenance;
import tech.model.Vehicule;
import tech.repo.EcheanceRepo;
import tech.service.EcheanceService;
import tech.service.Type_echeanceService;
import tech.service.VehiculeService;  

/**
 * VehiculeController
 */
@Controller 
public class EcheanceController {
 
    @Autowired
    private EcheanceService e;
    
    @Autowired
    private EcheanceRepo r;
    
    @Autowired
    private VehiculeService vehiculeService ;
    //instancer service
    @Autowired
    private Type_echeanceService type_echeanceService;
	 @PostMapping ("/insertEcheance")
	    public String insertVehicule(@ModelAttribute Echeance echeance, @RequestParam("type_echeance") Long id_type_echeance, @RequestParam("vehicule") Long id_vehicule)
	    { 
	        e.insertEcheance(echeance, id_type_echeance, id_vehicule);
	        return "redirect:page_echeance";
	    }

	 @GetMapping ("/page_update_echeance")
	    public ModelAndView page_update_echeance()  { 
		 ModelAndView  modelAndView=new ModelAndView(); 
	        List<Vehicule> listVehicule=new ArrayList<Vehicule>();
	        List<Type_echeance> listType_echeance=  new ArrayList<Type_echeance>();
	        listVehicule=vehiculeService.getAllVehicule();  
	        listType_echeance=type_echeanceService.getAllType_echeance();
	        modelAndView.addObject("listVehicule",listVehicule); 
	        modelAndView.addObject("listType_echeance",listType_echeance);
	        modelAndView.setViewName("updateEcheance");
	        return modelAndView;  
	      
	    }
	 
	 @PostMapping ("/updateEcheance")
	 
	    public String updateEcheance( @RequestParam("type_echeance") Long type_echeance, @RequestParam("date_renouvellement") String date_renouvellement, @RequestParam("vehicule") Long vehicule)
	    {  
	         r.updateEcheance(type_echeance, date_renouvellement, vehicule);
	        return "redirect:page_update_echeance";
	    }

}