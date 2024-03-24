package com.stock.app.services;

import com.stock.app.models.ProduitPVReception;
import com.stock.app.repositories.ProduitPVReceptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitPVReceptionService {

    private final ProduitPVReceptionRepository produitPVReceptionRepository;

    @Autowired
    public ProduitPVReceptionService(ProduitPVReceptionRepository produitPVReceptionRepository) {
        this.produitPVReceptionRepository = produitPVReceptionRepository;
    }

    public List<ProduitPVReception> getProduitPVReceptionsByProduitId(Long produitId) {
        return produitPVReceptionRepository.findByProduitFini_Id(produitId);
    }

    public List<ProduitPVReception> getProduitPVReceptionsByPvReceptionId(Long pvReceptionId) {
        return produitPVReceptionRepository.findByPvReception_Id(pvReceptionId);
    }

    // Méthodes CRUD de base

    public Page<ProduitPVReception> getAllProduitPVReceptions(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return produitPVReceptionRepository.findAll(pageable);
    }

    public ProduitPVReception getProduitPVReceptionById(Long id) {
        return produitPVReceptionRepository.findById(id).orElse(null);
    }

    public ProduitPVReception addProduitPVReception(ProduitPVReception produitPVReception) {
        return produitPVReceptionRepository.save(produitPVReception);
    }

    public ProduitPVReception updateProduitPVReception(ProduitPVReception produitPVReception) {
        return produitPVReceptionRepository.saveAndFlush(produitPVReception);
    }

    public void deleteProduitPVReceptionById(Long id) {
        produitPVReceptionRepository.deleteById(id);
    }

}
