package tech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

/**
 * ProduitController
 */
@Controller 
public class ProduitController {

    @PostMapping("/redirection")
    public RedirectView redirection() {
        System.out.print("tafiditra");
        return new RedirectView("/login");
    }


    @GetMapping("/login")
    public String login() {
        System.out.print("tafiditra");
        return "accueil_normal";
    }

/*
    @Autowired
    ProduitService pServ;

    @Autowired
    ImportService iServ;

    @Autowired
    MouvementProduitService mvServ;

    @GetMapping("/produit")
    public String list(Model model, @RequestParam(name = "page", required = false) Integer page) {
        if(page == null || page <= 0)
            page = 0;
        else if(page > ProduitService.MAX_PAGE_SIZE+1)
            page = ProduitService.MAX_PAGE_SIZE+1;
        else
            page--;

        Page<ProduitStock> produits = pServ.findAllProduitStock(page);
        model.addAttribute("produits", produits);
        model.addAttribute("pages", pServ.countPages());
        model.addAttribute("page", page + 1);
        return "stock-list";
    }



    @GetMapping("/produit/vente")
    public String vente(Model model) {
        model.addAttribute("produits", pServ.findAllProduit());
        return "vente-produit";
    }*/



}