package com.stock.app.controllers;

import com.stock.app.dtos.CommandeClientDto;
import com.stock.app.exceptions.CommandeClientNotFoundException;
import com.stock.app.mappers.CommandeClientMapper;
import com.stock.app.models.CommandeClient;
import com.stock.app.services.CommandeClientService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commandeclients")
@AllArgsConstructor
public class CommandeClientController {

    private final CommandeClientService commandeClientService;
    private final CommandeClientMapper commandeClientMapper;

    @GetMapping("/{id}")
    public CommandeClientDto getCommandeClientById(@PathVariable Long id) throws CommandeClientNotFoundException {
        CommandeClient commandeClient = commandeClientService.getCommandeClientById(id);
        return commandeClientMapper.commandeClientTocommandeClientDto(commandeClient);
    }

    @GetMapping
    public Page<CommandeClientDto> getAllCommandeClients(@RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "10") int size) {
        Page<CommandeClient> commandeClients = commandeClientService.getAllCommandeClients(page, size);
        return commandeClients.map(commandeClientMapper::commandeClientTocommandeClientDto);
    }

    @PostMapping
    public CommandeClient addCommandeClient(@RequestBody CommandeClient commandeClient) {
        return commandeClientService.addCommandeClient(commandeClient);
    }

    @PutMapping("/{id}")
    public CommandeClient updateCommandeClient(@PathVariable Long id, @RequestBody CommandeClient commandeClient) {
        commandeClient.setId(id);
        return commandeClientService.updateCommandeClient(commandeClient);
    }

    @DeleteMapping("/{id}")
    public void deleteCommandeClientById(@PathVariable Long id) throws CommandeClientNotFoundException {
        commandeClientService.deleteCommandeClientById(id);
    }
}
