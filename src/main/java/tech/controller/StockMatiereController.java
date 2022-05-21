package tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;  
import  tech.model.StockMatiere; 
import  tech.service.StockMatiereService; 

/**
 * ProduitController
 */
@Controller 
public class StockMatiereController {

    @Autowired
    private StockMatiereService stockMatiereService;
    //instancer service


    @PostMapping ("/insertMatiere")
    public String insertMatiere(@ModelAttribute StockMatiere matiere, @RequestParam("matiere") Long idMatiere)
    {
        stockMatiereService.insertMatiere(matiere,idMatiere);
        return "redirect:page_matiere";
    }



}