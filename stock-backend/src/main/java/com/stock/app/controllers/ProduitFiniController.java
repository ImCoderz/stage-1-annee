package com.stock.app.controllers;

import com.stock.app.models.ProduitFini;
import com.stock.app.services.ProduitFiniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitFiniController {

    private final ProduitFiniService produitFiniService;

    @Autowired
    public ProduitFiniController(ProduitFiniService produitFiniService) {
        this.produitFiniService = produitFiniService;
    }

    @GetMapping("/{id}")
    public ProduitFini getProduitFiniById(@PathVariable Long id) {
        return produitFiniService.getProduitFiniById(id);
    }

    @GetMapping
    public Page<ProduitFini> getAllProduitsFinis(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10") int size) {
        return produitFiniService.getAllProduitsFinis(page, size);
    }

    @PostMapping
    public ProduitFini addProduitFini(@RequestBody ProduitFini produitFini) {
        return produitFiniService.addProduitFini(produitFini);
    }

    @PutMapping("/{id}")
    public ProduitFini updateProduitFini(@PathVariable Long id, @RequestBody ProduitFini produitFini) {
        produitFini.setId(id);
        return produitFiniService.updateProduitFini(produitFini);
    }

    @DeleteMapping("/{id}")
    public void deleteProduitFiniById(@PathVariable Long id) {
        produitFiniService.deleteProduitFiniById(id);
    }
}
