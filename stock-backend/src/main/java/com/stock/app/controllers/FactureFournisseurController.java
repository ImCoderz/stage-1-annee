package com.stock.app.controllers;

import com.stock.app.models.FactureFournisseur;
import com.stock.app.services.FactureFournisseurService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/facturesfournisseurs")
@AllArgsConstructor
public class FactureFournisseurController {

    private final FactureFournisseurService factureFournisseurService;

    @GetMapping
    public Page<FactureFournisseur> getAllFactureFournisseurs(@RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "10") int size) {
        return factureFournisseurService.getAllFactureFournisseurs(page, size);
    }

    @GetMapping("/{id}")
    public FactureFournisseur getFactureFournisseurById(@PathVariable Long id) {
        return factureFournisseurService.getFactureFournisseurById(id);
    }

    @PostMapping
    public FactureFournisseur addFactureFournisseur(@RequestBody FactureFournisseur factureFournisseur) {
        return factureFournisseurService.addFactureFournisseur(factureFournisseur);
    }

    @PutMapping("/{id}")
    public FactureFournisseur updateFactureFournisseur(@PathVariable Long id, @RequestBody FactureFournisseur factureFournisseur) {
        factureFournisseur.setId(id);
        return factureFournisseurService.updateFactureFournisseur(factureFournisseur);
    }

    @DeleteMapping("/{id}")
    public void deleteFactureFournisseurById(@PathVariable Long id) {
        factureFournisseurService.deleteFactureFournisseurById(id);
    }
}
