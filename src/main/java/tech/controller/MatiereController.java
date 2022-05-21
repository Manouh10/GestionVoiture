package tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.servlet.ModelAndView;
import  tech.model.Matiere;
import  tech.model.StockMatiere; 
import  tech.service.MatiereService;
import  tech.service.StockMatiereService; 

import java.util.ArrayList;
import java.util.List;

/**
 * ProduitController
 */
@Controller 
public class MatiereController {

    @Autowired
    private MatiereService matiereService;
    @Autowired
    private StockMatiereService stockMatiereService;

    //instancer service
    @GetMapping ("/page_matiere")
    public ModelAndView page_matiere() {
        ModelAndView  modelAndView=new ModelAndView();
        List<Matiere> listMatiere=new ArrayList<Matiere>();
        listMatiere=matiereService.getAllMatiere();
        modelAndView.addObject("listMatiere",listMatiere);
        List<StockMatiere> listStock= new ArrayList<>();
        listStock=stockMatiereService.getAllStockMatiere();
        modelAndView.addObject("listStock",listStock);
        modelAndView.setViewName("matiere");
        return  modelAndView;
    }

}