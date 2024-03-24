package com.stock.app.services;

import com.stock.app.models.Boutique;
import com.stock.app.repositories.BoutiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoutiqueService {

    private final BoutiqueRepository boutiqueRepository;

    @Autowired
    public BoutiqueService(BoutiqueRepository boutiqueRepository) {
        this.boutiqueRepository = boutiqueRepository;
    }

    public Boutique getBoutiqueById(Long id) {
        return boutiqueRepository.findById(id).orElse(null);
    }

    public List<Boutique> getAllBoutiques() {
        return boutiqueRepository.findAll();
    }

    public Boutique addBoutique(Boutique boutique) {
        return boutiqueRepository.save(boutique);
    }

    public Boutique updateBoutique(Boutique boutique) {
        return boutiqueRepository.saveAndFlush(boutique);
    }

    public void deleteBoutiqueById(Long id) {
        boutiqueRepository.deleteById(id);
    }
}
