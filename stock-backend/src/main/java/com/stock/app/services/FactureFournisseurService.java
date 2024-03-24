package com.stock.app.services;

import com.stock.app.models.CommandeFournisseur;
import com.stock.app.models.FactureFournisseur;
import com.stock.app.models.ProduitFactureFournisseur;
import com.stock.app.repositories.FactureFournisseurRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class FactureFournisseurService {

    private final FactureFournisseurRepository factureFournisseurRepository;

    public Page<FactureFournisseur> getAllFactureFournisseurs(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return factureFournisseurRepository.findAll(pageable);
    }

    public FactureFournisseur getFactureFournisseurById(Long id) {
        return factureFournisseurRepository.findById(id).orElse(null);
    }

    public FactureFournisseur addFactureFournisseur(FactureFournisseur factureFournisseur) {
        return factureFournisseurRepository.save(factureFournisseur);
    }

    public FactureFournisseur updateFactureFournisseur(FactureFournisseur factureFournisseur) {
        return factureFournisseurRepository.saveAndFlush(factureFournisseur);
    }

    public void deleteFactureFournisseurById(Long id) {
        factureFournisseurRepository.deleteById(id);
    }
}
