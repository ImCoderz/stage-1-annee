package com.stock.app.services;

import com.stock.app.models.CommandeProduitClient;
import com.stock.app.repositories.CommandeProduitClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeProduitClientService {

    private final CommandeProduitClientRepository commandeProduitClientRepository;

    @Autowired
    public CommandeProduitClientService(CommandeProduitClientRepository commandeProduitClientRepository) {
        this.commandeProduitClientRepository = commandeProduitClientRepository;
    }

    public Page<CommandeProduitClient> getAllCommandeProduitClients(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return commandeProduitClientRepository.findAll(pageable);
    }


    public CommandeProduitClient getCommandeProduitClientById(Long id) {
        Optional<CommandeProduitClient> optionalCommandeProduitClient = commandeProduitClientRepository.findById(id);
        return optionalCommandeProduitClient.orElse(null);
    }
    public CommandeProduitClient updateCommandeProduitClient(CommandeProduitClient commandeProduitClient) {
        return commandeProduitClientRepository.saveAndFlush(commandeProduitClient);
    }

    public CommandeProduitClient addCommandeProduitClient(CommandeProduitClient commandeProduitClient) {
        return commandeProduitClientRepository.save(commandeProduitClient);
    }

    public void deleteCommandeProduitClientById(Long id) {

        commandeProduitClientRepository.deleteById(id);
    }

    public List<CommandeProduitClient> getCommandeProduitClientsByCommandeClientId(Long commandeClientId) {
        return commandeProduitClientRepository.findByCommandeClientId(commandeClientId);
    }

    public List<CommandeProduitClient> getCommandeProduitClientsByProduitId(Long produitId) {
        return commandeProduitClientRepository.findByProduitFini_Id(produitId);
    }
}
