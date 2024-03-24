package com.stock.app.controllers;

import com.stock.app.dtos.ClientDto;
import com.stock.app.exceptions.ClientNotFoundException;
import com.stock.app.mappers.ClientMapper;
import com.stock.app.mappers.ClientMapperImpl;
import com.stock.app.models.Client;
import com.stock.app.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @GetMapping("/{id}")
    public ClientDto getClientById(@PathVariable Long id) throws ClientNotFoundException {
        Client client = clientService.getClientById(id);
        return clientMapper.clientToClientDto(client);
    }

    @GetMapping
    public Page<ClientDto> getAllClients(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size) {
        Page<Client> clients = clientService.getAllClients(page, size);
        return clients.map(clientMapper::clientToClientDto);
    }

    @PostMapping
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client) {
        client.setId(id);
        return clientService.updateClient(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClientById(@PathVariable Long id) throws ClientNotFoundException {
        clientService.deleteClientById(id);
    }
}
