package tech.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import tech.model.Administrateur;
import tech.repo.Type_maintenanceRepo;
import tech.service.AdministrateurService;
import tech.service.VehiculeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession; 

@Controller 
public class AdministrateurController {

    @Autowired
    private AdministrateurService adminService;  
    
    @Autowired
    private VehiculeService vehiculeService;  
    
    @Autowired
    private Type_maintenanceRepo type_maintenanceRepo;   
    
    @GetMapping ("/page_index")
    public String page_index() {
    	// System.out.println("aaaa");
        return "index"; 
    }
    
    @GetMapping ("/page_accueil_admin")
    public String page_accueil_admin(Model m,HttpServletRequest request) {
    	 HttpSession session=request.getSession();
       m.addAttribute("loginAdmin",(Administrateur) session.getAttribute("logAdmin"));
        return "accueil_admin";
    }
    
    

    @PostMapping ("/loginAdmin")
    public String loginAdmin(@ModelAttribute Administrateur admin, HttpServletRequest request)
    {
        String retour ="";
        Administrateur ad = adminService.loginSuper(admin);
       
        if(ad==null)
        {
            retour="redirect:page_index?error=1";
        }
        else{
            HttpSession session=request.getSession();
            session.setAttribute("logAdmin",ad);
            retour="redirect:page_accueil_admin";}
        return retour;
    }
    
    @PostMapping ("/logout")
    public ModelAndView logout()
    { 
    	ModelAndView  modelAndView=new ModelAndView(); 
    	modelAndView.addObject("logout","vous etes deconnecte"); 
        modelAndView.setViewName("index"); 
        return  modelAndView;   
    }

   
}