package com.stock.app.services;

import com.stock.app.models.CommandeProduitClient;
import com.stock.app.models.FactureClient;
import com.stock.app.models.ProduitFactureClient;
import com.stock.app.repositories.FactureClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FactureClientService {

    private final FactureClientRepository factureClientRepository;
    private final CommandeProduitClientService commandeProduitClientService;
    private final CommandeClientService commandeClientService;
    private final ProduitFactureClientService produitFactureClientService;

    public Page<FactureClient> getAllFactureClients(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return factureClientRepository.findAll(pageable);
    }

    public FactureClient getFactureClientById(Long id) {
        return factureClientRepository.findById(id).orElse(null);
    }

    public FactureClient addFactureClient(FactureClient factureClient) {
        return factureClientRepository.save(factureClient);
    }

    public FactureClient addFactureClient(Long commandeClientId) {

        List<ProduitFactureClient> produitFactureClientList=new ArrayList<>();
        List<CommandeProduitClient> commandeProduitClientList=commandeProduitClientService.getCommandeProduitClientsByCommandeClientId(commandeClientId);
        FactureClient factureClient=new FactureClient();
        commandeProduitClientList.forEach((c)->{
            ProduitFactureClient produitFactureClient=new ProduitFactureClient();
            produitFactureClient.setProduitFini(c.getProduitFini());
            produitFactureClient.setQuantite(c.getQuantite());
            factureClient.setPrixTotal(factureClient.getPrixTotal()+c.getQuantite()*c.getProduitFini().getPrixUnitaire());
            produitFactureClientList.add(produitFactureClient);
        });
        factureClient.setDateFacture(LocalDate.now());
        factureClient.setPaiement(true);
        factureClient.setCommandeClient(commandeClientService.getCommandeClientById(commandeClientId));
        this.addFactureClient(factureClient);
        produitFactureClientList.stream().forEach((pfc)->{
            pfc.setFactureClient(factureClient);
            produitFactureClientService.addProduitFactureClient(pfc);
        });
        return factureClient;
    }

    public FactureClient updateFactureClient(FactureClient factureClient) {
        return factureClientRepository.saveAndFlush(factureClient);
    }

    public void deleteFactureClientById(Long id) {
        factureClientRepository.deleteById(id);
    }
}
