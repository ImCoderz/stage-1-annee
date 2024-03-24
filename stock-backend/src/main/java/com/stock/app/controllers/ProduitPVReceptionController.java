package com.stock.app.controllers;

import com.stock.app.models.ProduitPVReception;
import com.stock.app.services.ProduitPVReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produitpvreceptions")
public class ProduitPVReceptionController {

    private final ProduitPVReceptionService produitPVReceptionService;

    @Autowired
    public ProduitPVReceptionController(ProduitPVReceptionService produitPVReceptionService) {
        this.produitPVReceptionService = produitPVReceptionService;
    }

    @GetMapping
    public Page<ProduitPVReception> getAllProduitPVReceptions(@RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "10") int size) {
        return produitPVReceptionService.getAllProduitPVReceptions(page, size);
    }

    @GetMapping("/{id}")
    public ProduitPVReception getProduitPVReceptionById(@PathVariable Long id) {
        return produitPVReceptionService.getProduitPVReceptionById(id);
    }

    @PostMapping
    public ProduitPVReception addProduitPVReception(@RequestBody ProduitPVReception produitPVReception) {
        return produitPVReceptionService.addProduitPVReception(produitPVReception);
    }

    @PutMapping("/{id}")
    public ProduitPVReception updateProduitPVReception(@PathVariable Long id,
                                                       @RequestBody ProduitPVReception produitPVReception) {
        produitPVReception.setId(id);
        return produitPVReceptionService.updateProduitPVReception(produitPVReception);
    }

    @DeleteMapping("/{id}")
    public void deleteProduitPVReceptionById(@PathVariable Long id) {
        produitPVReceptionService.deleteProduitPVReceptionById(id);
    }
}
