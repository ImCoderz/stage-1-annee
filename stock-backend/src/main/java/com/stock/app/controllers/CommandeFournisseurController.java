package com.stock.app.controllers;

import com.stock.app.models.CommandeFournisseur;
import com.stock.app.services.CommandeFournisseurService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commandefournisseurs")
@AllArgsConstructor
public class CommandeFournisseurController {

    private final CommandeFournisseurService commandeFournisseurService;

    @GetMapping("/{id}")
    public CommandeFournisseur getCommandeFournisseurById(@PathVariable Long id) {
        return commandeFournisseurService.getCommandeFournisseurById(id);
    }

    @GetMapping
    public Page<CommandeFournisseur> getAllCommandesFournisseur(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return commandeFournisseurService.getAllCommandesFournisseur(page, size);
    }

    @PostMapping
    public CommandeFournisseur addCommandeFournisseur(@RequestBody CommandeFournisseur commandeFournisseur) {
        return commandeFournisseurService.addCommandeFournisseur(commandeFournisseur);
    }

    @PutMapping("/{id}")
    public CommandeFournisseur updateCommandeFournisseur(@PathVariable Long id, @RequestBody CommandeFournisseur commandeFournisseur) {
        commandeFournisseur.setId(id);
        return commandeFournisseurService.updateCommandeFournisseur(commandeFournisseur);
    }

    @DeleteMapping("/{id}")
    public void deleteCommandeFournisseurById(@PathVariable Long id) {
        commandeFournisseurService.deleteCommandeFournisseurById(id);
    }
}
