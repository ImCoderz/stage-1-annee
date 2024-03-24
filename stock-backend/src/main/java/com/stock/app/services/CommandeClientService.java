package com.stock.app.services;

import com.stock.app.dtos.ProduitQuantite;
import com.stock.app.exceptions.ClientNotFoundException;
import com.stock.app.models.*;
import com.stock.app.repositories.CommandeClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class CommandeClientService {

    private final CommandeClientRepository commandeClientRepository;
    private final ClientService clientService;
    private final ProduitFiniService produitFiniService;
    private final BoutiqueService boutiqueService;
    private final CommandeProduitClientService commandeProduitClientService;





    public Page<CommandeClient> getAllCommandeClients(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return commandeClientRepository.findAll(pageable);
    }

    public CommandeClient getCommandeClientById(Long id) {
        return commandeClientRepository.findById(id).orElse(null);
    }

    public CommandeClient addCommandeClient(CommandeClient commandeClient) {
        return commandeClientRepository.save(commandeClient);
    }
    public CommandeClient addCommandeClient(Long clientId, Long boutiqueId, List<ProduitQuantite> produitQuantites) throws ClientNotFoundException {
        Client client =clientService.getClientById(clientId);
        Boutique boutique=boutiqueService.getBoutiqueById(boutiqueId);
        if(client != null && boutique != null) {
            CommandeClient commandeClient=new CommandeClient();
            commandeClient.setBoutique(boutique);
            commandeClient.setClient(client);
            commandeClient.setDateCommande(LocalDate.now());
            this.addCommandeClient(commandeClient);

            produitQuantites.forEach(pq->{
                ProduitFini produitFini=produitFiniService.getProduitFiniById(pq.getProduitId());
                CommandeProduitClient commandeProduitClient=new CommandeProduitClient();
                commandeProduitClient.setProduitFini(produitFini);
                commandeProduitClient.setQuantite(pq.getQuantite());
                commandeProduitClient.setCommandeClient(commandeClient);
                commandeProduitClientService.addCommandeProduitClient(commandeProduitClient);
            });
            return commandeClient;
        }
        return null;
    }

    public CommandeClient updateCommandeClient(CommandeClient commandeClient) {
        return commandeClientRepository.saveAndFlush(commandeClient);
    }

    public void deleteCommandeClientById(Long id) {
        commandeClientRepository.deleteById(id);
    }
}
