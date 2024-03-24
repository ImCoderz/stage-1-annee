package com.stock.app.services;

import com.stock.app.models.Fournisseur;
import com.stock.app.repositories.FournisseurRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FournisseurService {

    private final FournisseurRepository fournisseurRepository;
    public Page<Fournisseur> getAllFournisseurs(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return fournisseurRepository.findAll(pageable);
    }

    public Fournisseur getFournisseurById(Long id) {
        return fournisseurRepository.findById(id).orElse(null);
    }

    public Fournisseur addFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    public Fournisseur updateFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.saveAndFlush(fournisseur);
    }

    public void deleteFournisseurById(Long id) {
        fournisseurRepository.deleteById(id);
    }
}
