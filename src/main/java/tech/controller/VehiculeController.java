package tech.controller;

import java.io.IOException;
 
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.DocumentException;

import tech.model.Marque;
import tech.model.Trajet;
import tech.model.Type_vehicule;
import tech.model.Vehicule;
import tech.repo.VehiculeRepo;
import tech.service.MarqueService; 
import tech.service.Type_vehiculeService;
import tech.service.TrajetService;
import tech.service.VehiculeService; 

/**
 * VehiculeController
 */
@Controller 
public class VehiculeController {

    @Autowired
    private MarqueService marqueService;
    
    @Autowired
    private Type_vehiculeService t;
    
    @Autowired
    private VehiculeService v;
    
    @Autowired
    private TrajetService trajetService;
    
    @Autowired
    private VehiculeRepo vRepo;
    //instancer service
    
   //@Autowired
   // private MatiereService matiereService;
	
	@GetMapping("/page_vehicule")
    public ModelAndView page_vehicule() {
        ModelAndView  modelAndView=new ModelAndView();
        List<Marque> listMarque=new ArrayList<Marque>();
        listMarque=marqueService.getAllMarque();
        for(int i=0;i<listMarque.size();i++)
        {
        	System.out.print(listMarque.get(i).getNom_marque());
        }
        List<Type_vehicule> listType_vehicule=new ArrayList<Type_vehicule>();
        listType_vehicule=t.getAllType_vehicule();
        for(int i=0;i<listType_vehicule.size();i++)
        {
        	System.out.print(listType_vehicule.get(i).getNom_type_vehicule());
        }
        modelAndView.addObject("listVehicule",vRepo.findAll());
        modelAndView.addObject("listMarque",listMarque);
        modelAndView.addObject("listType_vehicule",listType_vehicule); 
        modelAndView.setViewName("insertionVehicule");
        return modelAndView;   
    }


	 @PostMapping ("/insertVehicule")
	    public String insertVehicule(@ModelAttribute Vehicule vehicule, @RequestParam("marque") Long id_marque, @RequestParam("type_vehicule") Long id_type_vehicule)
	    {
	        v.insertVehicule(vehicule, id_marque, id_type_vehicule);
	        return "redirect:page_vehicule";
	    }
	 
	 @GetMapping("/export")
	    public void generatePdf(HttpServletResponse response, @RequestParam("vehicule") Long vehicule) throws DocumentException, IOException {
	        response.setContentType("application/pdf");
	        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
	        String currentDateTime = dateFormat.format(new Date());
	        String headerkey = "Content-Disposition";
	        String headervalue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
	        response.setHeader(headerkey, headervalue);

	        List<Trajet> listTrajet = trajetService.getAllTrajetById(vehicule);

	        PDFGenerator generator = new PDFGenerator();
	        generator.setListTrajet(listTrajet);
	       // System.out.println(listTrajet.get(0).getMotif());
	       // System.out.println(listTrajet.get(0).getDate_depart());
	        generator.generate(response);
	}



}