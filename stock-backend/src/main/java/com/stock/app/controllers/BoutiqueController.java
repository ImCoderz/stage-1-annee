package com.stock.app.controllers;

import com.stock.app.models.Boutique;
import com.stock.app.services.BoutiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boutiques")
public class BoutiqueController {

    private final BoutiqueService boutiqueService;

    @Autowired
    public BoutiqueController(BoutiqueService boutiqueService) {
        this.boutiqueService = boutiqueService;
    }

    @GetMapping("/{id}")
    public Boutique getBoutiqueById(@PathVariable Long id) {
        return boutiqueService.getBoutiqueById(id);
    }

    @GetMapping
    public List<Boutique> getAllBoutiques() {
        return boutiqueService.getAllBoutiques();
    }

    @PostMapping
    public Boutique addBoutique(@RequestBody Boutique boutique) {
        return boutiqueService.addBoutique(boutique);
    }

    @PutMapping("/{id}")
    public Boutique updateBoutique(@PathVariable Long id, @RequestBody Boutique boutique) {
        boutique.setId(id);
        return boutiqueService.updateBoutique(boutique);
    }

    @DeleteMapping("/{id}")
    public void deleteBoutiqueById(@PathVariable Long id) {
        boutiqueService.deleteBoutiqueById(id);
    }
}
