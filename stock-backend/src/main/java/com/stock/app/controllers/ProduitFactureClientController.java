package com.stock.app.controllers;

import com.stock.app.models.ProduitFactureClient;
import com.stock.app.services.ProduitFactureClientService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produitfactureclients")
public class ProduitFactureClientController {

    private final ProduitFactureClientService produitFactureClientService;

    public ProduitFactureClientController(ProduitFactureClientService produitFactureClientService) {
        this.produitFactureClientService = produitFactureClientService;
    }

    @GetMapping("/{id}")
    public ProduitFactureClient getProduitFactureClientById(@PathVariable Long id) {
        return produitFactureClientService.getProduitFactureClientById(id);
    }

    @GetMapping
    public Page<ProduitFactureClient> getAllProduitFactureClients(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return produitFactureClientService.getAllProduitFactureClients(page, size);
    }

    @PostMapping
    public ProduitFactureClient addProduitFactureClient(@RequestBody ProduitFactureClient produitFactureClient) {
        return produitFactureClientService.addProduitFactureClient(produitFactureClient);
    }

    @PutMapping("/{id}")
    public ProduitFactureClient updateProduitFactureClient(@PathVariable Long id, @RequestBody ProduitFactureClient produitFactureClient) {
        produitFactureClient.setId(id);
        return produitFactureClientService.updateProduitFactureClient(produitFactureClient);
    }

    @DeleteMapping("/{id}")
    public void deleteProduitFactureClientById(@PathVariable Long id) {
        produitFactureClientService.deleteProduitFactureClientById(id);
    }
}
