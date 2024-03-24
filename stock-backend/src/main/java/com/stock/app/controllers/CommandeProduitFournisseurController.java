package com.stock.app.controllers;

import com.stock.app.models.CommandeProduitFournisseur;
import com.stock.app.services.CommandeProduitFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commandeProduitsFournisseurs")
public class CommandeProduitFournisseurController {

    private final CommandeProduitFournisseurService commandeProduitFournisseurService;

    @Autowired
    public CommandeProduitFournisseurController(CommandeProduitFournisseurService commandeProduitFournisseurService) {
        this.commandeProduitFournisseurService = commandeProduitFournisseurService;
    }

    @GetMapping
    public Page<CommandeProduitFournisseur> getAllCommandeProduitsFournisseurs(@RequestParam(defaultValue = "0") int page,
                                                                               @RequestParam(defaultValue = "10") int size) {
        return commandeProduitFournisseurService.getAllCommandeProduitsFournisseurs(page, size);
    }

    @GetMapping("/{id}")
    public CommandeProduitFournisseur getCommandeProduitFournisseurById(@PathVariable Long id) {
        return commandeProduitFournisseurService.getCommandeProduitFournisseurById(id);
    }

    @PostMapping
    public CommandeProduitFournisseur addCommandeProduitFournisseur(@RequestBody CommandeProduitFournisseur commandeProduitFournisseur) {
        return commandeProduitFournisseurService.addCommandeProduitClient(commandeProduitFournisseur);
    }

    @PutMapping("/{id}")
    public CommandeProduitFournisseur updateCommandeProduitFournisseur(@PathVariable Long id,
                                                                       @RequestBody CommandeProduitFournisseur commandeProduitFournisseur) {
        commandeProduitFournisseur.setId(id);
        return commandeProduitFournisseurService.updateCommandeProduitFournisseur(commandeProduitFournisseur);
    }

    @DeleteMapping("/{id}")
    public void deleteCommandeProduitFournisseurById(@PathVariable Long id) {
        commandeProduitFournisseurService.deleteCommandeProduitFournisseurById(id);
    }
}
