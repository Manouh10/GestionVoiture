package tech.controller;
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tech.model.Chauffeur;
import tech.model.Echeance;
import tech.model.Type_echeance;
import tech.model.Vehicule;
import tech.repo.EcheanceRepo; 
import tech.service.ChauffeurService;
import tech.service.EcheanceService;
import tech.service.GarageService;
import tech.service.TrajetService;
import tech.service.Type_echeanceService;
import tech.service.VehiculeService;
import tech.service.VoitureDispoService;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession; 

@Controller 
public class ChauffeurController {

    @Autowired
    private ChauffeurService chauffeurService;  
    
    @Autowired
    private VehiculeService vehiculeService;  
    
    @Autowired
    private VoitureDispoService vehiculeDispoService;
    
    @Autowired
    private Type_echeanceService type_echeanceService;
    
    @Autowired
    private EcheanceRepo echeanceRepo;
    
    @Autowired
    private GarageService garageService;
    
    @Autowired
    private TrajetService trajetService;
    
    @Autowired
    EcheanceService echeanceService;
   
    @GetMapping ("/page_accueil_chauffeur")
    public String page_accueil_chauffeur() {
        return "accueil_chauffeur";
    }
    
    @GetMapping ("/liste_trajet")
    public String liste_trajet() {
        return "listeTrajet";
    }
    
    @GetMapping ("/liste_vehicule_dispo")
    public ModelAndView liste_vehicule_dispo() throws Exception {
    	ModelAndView  modelAndView=new ModelAndView(); 
    	modelAndView.addObject("listVehiculeDispo",vehiculeDispoService.getAllVoitureDispo()); 
        modelAndView.setViewName("listeVehiculeDispo"); 
        return  modelAndView;   
    }
    
    @GetMapping ("/liste_echeance")
    public ModelAndView liste_echeance() throws Exception {
    	ModelAndView  modelAndView=new ModelAndView();  
    	List<Echeance> listEcheance= new ArrayList<Echeance>();
    	listEcheance = echeanceRepo.findAll();
    	List<String> listDate_echeance=  new ArrayList<String>(); 
        modelAndView.addObject("listEcheance",echeanceRepo.findAll()); 
 modelAndView.addObject("listGarage",garageService.getListEcheance_with_Color(garageService.getAllGarage()));
        modelAndView.addObject("listDate_echeance",listDate_echeance); 
        modelAndView.addObject("color","blue"); 
        modelAndView.setViewName("listeEcheance");
        return  modelAndView;  
    }
    
    @GetMapping ("/page_trajet")
    public ModelAndView page_trajet(@RequestParam(name="error",required=false) Long error) {
    	
    	ModelAndView  modelAndView=new ModelAndView();
    	if(error!=null)
    	{
    		modelAndView.addObject("negatif","kilometrage negatif");
    	}
        List<Vehicule> listVehicule=new ArrayList<Vehicule>();
        listVehicule=vehiculeService.getAllVehicule();  
        modelAndView.addObject("listVehicule",listVehicule);
        List<Chauffeur> listChauffeur= new ArrayList<Chauffeur>();
        listChauffeur=chauffeurService.getAllChauffeur();
        modelAndView.addObject("listChauffeur",listChauffeur);
        modelAndView.setViewName("insertionTrajet");
        return  modelAndView; 
    }
    
     
    
    @GetMapping("/page_echeance")
    public ModelAndView page_echeance() {
        ModelAndView  modelAndView=new ModelAndView(); 
        List<Vehicule> listVehicule=new ArrayList<Vehicule>();
        List<Type_echeance> listType_echeance=  new ArrayList<Type_echeance>();
        listVehicule=vehiculeService.getAllVehicule();  
        listType_echeance=type_echeanceService.getAllType_echeance();
        modelAndView.addObject("listVehicule",listVehicule); 
        modelAndView.addObject("listType_echeance",listType_echeance);
        modelAndView.setViewName("insertionEcheance");
        return modelAndView;   
    }
    
    

    @PostMapping ("/loginChauffeur")
    public String loginChauffeur(@ModelAttribute Chauffeur chauffeur, HttpServletRequest request)
    {
    	
        String retour ="";
        Chauffeur ad = chauffeurService.loginChauffeur(chauffeur);
        if(ad==null)
        {
            retour="redirect:page_index?error=1";
         
          System.out.println(chauffeur.getMot_de_passe());
        }
        else{
            HttpSession session=request.getSession();
            session.setAttribute("logChauffeur",ad);
            retour="redirect:page_accueil_chauffeur";}
        return retour;
    }

    /*@GetMapping ("/inscrire")
    public ModelAndView inscrire() {
        ModelAndView  modelAndView=new ModelAndView();
        List<Objet> list=new ArrayList<Objet>();
        //atao try catch na tode appel fct
        try{fct}
        catch (Exceptione e){e.p}
        modelAndView.addObject("nom_cle",list);
        modelAndView.setViewName("view");
        return  modelAndView;
    }*/
}