package com.stock.app.controllers;

import com.stock.app.models.CommandeProduitClient;
import com.stock.app.services.CommandeProduitClientService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commandesproduitclient")
@AllArgsConstructor
public class CommandeProduitClientController {

    private final CommandeProduitClientService commandeProduitClientService;

    @GetMapping
    public Page<CommandeProduitClient> getAllCommandeProduitClients(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return commandeProduitClientService.getAllCommandeProduitClients(page, size);
    }


    @PostMapping
    public CommandeProduitClient addCommandeProduitClient(@RequestBody CommandeProduitClient commandeProduitClient) {
        return commandeProduitClientService.addCommandeProduitClient(commandeProduitClient);
    }

    @PutMapping("/{id}")
    public CommandeProduitClient updateCommandeProduitClient(@PathVariable Long id, @RequestBody CommandeProduitClient commandeProduitClient) {
        commandeProduitClient.setId(id);
        return commandeProduitClientService.updateCommandeProduitClient(commandeProduitClient);
    }

    @DeleteMapping("/{id}")
    public void deleteCommandeProduitClientById(@PathVariable Long id) {
        commandeProduitClientService.deleteCommandeProduitClientById(id);
    }
}
