package com.stock.app.controllers;

import com.stock.app.dtos.FournisseurDto;
import com.stock.app.exceptions.FournisseurNotFoundException;
import com.stock.app.mappers.FournisseurMapper;
import com.stock.app.models.Fournisseur;
import com.stock.app.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fournisseurs")
public class FournisseurController {

    private final FournisseurService fournisseurService;
    private final FournisseurMapper fournisseurMapper;

    @Autowired
    public FournisseurController(FournisseurService fournisseurService, FournisseurMapper fournisseurMapper) {
        this.fournisseurService = fournisseurService;
        this.fournisseurMapper = fournisseurMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FournisseurDto> getFournisseurById(@PathVariable Long id) {
        Fournisseur fournisseur = fournisseurService.getFournisseurById(id);
        FournisseurDto fournisseurDto = fournisseurMapper.fournisseurToFournisseurDto(fournisseur);
        return ResponseEntity.ok(fournisseurDto);
    }

    @GetMapping
    public ResponseEntity<Page<FournisseurDto>> getAllFournisseurs(@RequestParam(defaultValue = "0") int page,
                                                                   @RequestParam(defaultValue = "10") int size) {
        Page<Fournisseur> fournisseurs = fournisseurService.getAllFournisseurs(page, size);
        Page<FournisseurDto> fournisseurDtos = fournisseurs.map(fournisseurMapper::fournisseurToFournisseurDto);
        return ResponseEntity.ok(fournisseurDtos);
    }

    @PostMapping
    public ResponseEntity<Fournisseur> addFournisseur(@RequestBody Fournisseur fournisseur) {
        Fournisseur savedFournisseur = fournisseurService.addFournisseur(fournisseur);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFournisseur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable Long id, @RequestBody Fournisseur fournisseur) {
        fournisseur.setId(id);
        Fournisseur updatedFournisseur = fournisseurService.updateFournisseur(fournisseur);
        return ResponseEntity.ok(updatedFournisseur);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFournisseurById(@PathVariable Long id) {
        fournisseurService.deleteFournisseurById(id);
        return ResponseEntity.noContent().build();
    }
}
