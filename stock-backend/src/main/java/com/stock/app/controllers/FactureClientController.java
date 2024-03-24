package com.stock.app.controllers;

import com.stock.app.models.FactureClient;
import com.stock.app.services.FactureClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/facturesclients")
public class FactureClientController {

    private final FactureClientService factureClientService;

    @Autowired
    public FactureClientController(FactureClientService factureClientService) {
        this.factureClientService = factureClientService;
    }

    @GetMapping("/{id}")
    public FactureClient getFactureClientById(@PathVariable Long id) {
        return factureClientService.getFactureClientById(id);
    }

    @GetMapping
    public Page<FactureClient> getAllFactureClients(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10") int size) {
        return factureClientService.getAllFactureClients(page, size);
    }

    @PostMapping
    public FactureClient addFactureClient(@RequestBody FactureClient factureClient) {
        return factureClientService.addFactureClient(factureClient);
    }

    @PutMapping("/{id}")
    public FactureClient updateFactureClient(@PathVariable Long id, @RequestBody FactureClient factureClient) {
        factureClient.setId(id);
        return factureClientService.updateFactureClient(factureClient);
    }

    @DeleteMapping("/{id}")
    public void deleteFactureClientById(@PathVariable Long id) {
        factureClientService.deleteFactureClientById(id);
    }

    @PostMapping("/create-from-commande/{commandeId}")
    public FactureClient createFactureFromCommande(@PathVariable Long commandeId) {
        return factureClientService.addFactureClient(commandeId);
    }
}
