package com.stock.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stock.app.models.ProduitFini;
import com.stock.app.repositories.ProduitFiniRepository;

import java.util.List;

@Service
public class ProduitFiniService {

    @Autowired
    private ProduitFiniRepository produitFiniRepository;

    public List<ProduitFini> getAllProduitsFini() {
        return produitFiniRepository.findAll();
    }

    // Méthode pour récupérer un produit fini par son identifiant
    public ProduitFini getProduitFiniById(Long id) {

        return produitFiniRepository.findById(id).orElse(null);
    }

    public Page<ProduitFini> getAllProduitsFinis(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return produitFiniRepository.findAll(pageable);
    }

    public ProduitFini addProduitFini(ProduitFini produitFini) {
        return produitFiniRepository.save(produitFini);
    }

    public ProduitFini updateProduitFini(ProduitFini produitFini) {
        return produitFiniRepository.saveAndFlush(produitFini);
    }

    public void deleteProduitFiniById(Long id) {
        produitFiniRepository.deleteById(id);
    }


}
