package com.stock.app.controllers;

import com.stock.app.models.ProduitFactureFournisseur;
import com.stock.app.services.ProduitFactureFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produitsfacturefournisseur")
public class ProduitFactureFournisseurController {

    private final ProduitFactureFournisseurService produitFactureFournisseurService;

    @Autowired
    public ProduitFactureFournisseurController(ProduitFactureFournisseurService produitFactureFournisseurService) {
        this.produitFactureFournisseurService = produitFactureFournisseurService;
    }

    @GetMapping("/{id}")
    public ProduitFactureFournisseur getProduitFactureFournisseurById(@PathVariable Long id) {
        return produitFactureFournisseurService.getProduitFactureFournisseurById(id);
    }

    @GetMapping
    public Page<ProduitFactureFournisseur> getAllProduitFactureFournisseurs(@RequestParam(defaultValue = "0") int page,
                                                                            @RequestParam(defaultValue = "10") int size) {
        return produitFactureFournisseurService.getAllProduitFactureFournisseurs(page, size);
    }

    @PostMapping
    public ProduitFactureFournisseur addProduitFactureFournisseur(@RequestBody ProduitFactureFournisseur produitFactureFournisseur) {
        return produitFactureFournisseurService.addProduitFactureFournisseur(produitFactureFournisseur);
    }

    @PutMapping("/{id}")
    public ProduitFactureFournisseur updateProduitFactureFournisseur(@PathVariable Long id, @RequestBody ProduitFactureFournisseur produitFactureFournisseur) {
        produitFactureFournisseur.setId(id);
        return produitFactureFournisseurService.updateProduitFactureFournisseur(produitFactureFournisseur);
    }

    @DeleteMapping("/{id}")
    public void deleteProduitFactureFournisseurById(@PathVariable Long id) {
        produitFactureFournisseurService.deleteProduitFactureFournisseurById(id);
    }
}
