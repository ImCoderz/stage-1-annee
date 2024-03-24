package com.stock.app.services;

import com.stock.app.models.ProduitFactureFournisseur;
import com.stock.app.repositories.ProduitFactureFournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitFactureFournisseurService {

    private final ProduitFactureFournisseurRepository produitFactureFournisseurRepository;

    @Autowired
    public ProduitFactureFournisseurService(ProduitFactureFournisseurRepository produitFactureFournisseurRepository) {
        this.produitFactureFournisseurRepository = produitFactureFournisseurRepository;
    }

    public List<ProduitFactureFournisseur> getProduitFactureFournisseursByFactureFournisseurId(Long factureFournisseurId) {
        return produitFactureFournisseurRepository.findByFactureFournisseur_Id(factureFournisseurId);
    }

    public List<ProduitFactureFournisseur> getProduitFactureFournisseursByProduitId(Long produitId) {
        return produitFactureFournisseurRepository.findByProduitFini_Id(produitId);
    }

    // Méthodes CRUD de base

    public Page<ProduitFactureFournisseur> getAllProduitFactureFournisseurs(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return produitFactureFournisseurRepository.findAll(pageable);
    }

    public ProduitFactureFournisseur getProduitFactureFournisseurById(Long id) {
        return produitFactureFournisseurRepository.findById(id).orElse(null);
    }

    public ProduitFactureFournisseur addProduitFactureFournisseur(ProduitFactureFournisseur produitFactureFournisseur) {
        return produitFactureFournisseurRepository.save(produitFactureFournisseur);
    }

    public ProduitFactureFournisseur updateProduitFactureFournisseur(ProduitFactureFournisseur produitFactureFournisseur) {
        return produitFactureFournisseurRepository.saveAndFlush(produitFactureFournisseur);
    }

    public void deleteProduitFactureFournisseurById(Long id) {
        produitFactureFournisseurRepository.deleteById(id);
    }
}
