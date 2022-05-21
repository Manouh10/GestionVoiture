package tech.controller;
 
 
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tech.model.Maintenance;
import tech.model.Trajet;
import tech.model.Type_echeance;
import tech.model.Type_maintenance;
import tech.model.Vehicule;
import tech.repo.Type_maintenanceRepo;
import tech.service.MaintenanceService;
import tech.service.TrajetService;
import tech.service.Type_maintenanceService;
import tech.service.VehiculeService; 
 
/**
 * MaintenanceController
 */
@Controller 
public class MaintenanceController {

     
	@Autowired
    private MaintenanceService maintenanceService; 
	
	@Autowired
	Type_maintenanceService type_maintenanceService;
	
	@Autowired
	VehiculeService vehiculeService;
	 @PostMapping ("/insertMaintenance")
	    public String insertMaintenance(@ModelAttribute Maintenance maintenance, @RequestParam("type_maintenance") Long id_type_maintenance, @RequestParam("vehicule") Long id_vehicule)
	    {
		 maintenanceService.insertMaintenance(maintenance, id_type_maintenance, id_vehicule);
	        return "redirect:page_main";
	    } 
	 
	 
	 
	 @GetMapping("/page_main")
	    public ModelAndView page_main() {
	        ModelAndView  modelAndView=new ModelAndView(); 
	        List<Vehicule> listVehicule=new ArrayList<Vehicule>();
	        List<Type_maintenance> listType_maintenance=  new ArrayList<Type_maintenance>();
	        listType_maintenance=type_maintenanceService.getAllTypeMaintenance();
	        listVehicule=vehiculeService.getAllVehicule();  
	        modelAndView.addObject("listVehicule",listVehicule); 
	        modelAndView.addObject("listType_maintenance",listType_maintenance);
	        modelAndView.setViewName("insertionMaintenance");
	        return modelAndView;   
	    }


}