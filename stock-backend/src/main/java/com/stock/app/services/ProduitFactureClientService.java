package com.stock.app.services;

import com.stock.app.models.ProduitFactureClient;
import com.stock.app.repositories.ProduitFactureClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitFactureClientService {

    private final ProduitFactureClientRepository produitFactureClientRepository;

    @Autowired
    public ProduitFactureClientService(ProduitFactureClientRepository produitFactureClientRepository) {
        this.produitFactureClientRepository = produitFactureClientRepository;
    }

    public List<ProduitFactureClient> getProduitFactureClientsByFactureClientId(Long factureClientId) {
        return produitFactureClientRepository.findByFactureClient_Id(factureClientId);
    }

    public List<ProduitFactureClient> getProduitFactureClientsByProduitId(Long produitId) {
        return produitFactureClientRepository.findByProduitFini_Id(produitId);
    }

    public Page<ProduitFactureClient> getAllProduitFactureClients(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return produitFactureClientRepository.findAll(pageable);
    }

    public ProduitFactureClient getProduitFactureClientById(Long id) {
        return produitFactureClientRepository.findById(id).orElse(null);
    }

    public ProduitFactureClient addProduitFactureClient(ProduitFactureClient produitFactureClient) {
        return produitFactureClientRepository.save(produitFactureClient);
    }

    public ProduitFactureClient updateProduitFactureClient(ProduitFactureClient produitFactureClient) {
        return produitFactureClientRepository.saveAndFlush(produitFactureClient);
    }

    public void deleteProduitFactureClientById(Long id) {
        produitFactureClientRepository.deleteById(id);
    }

}
