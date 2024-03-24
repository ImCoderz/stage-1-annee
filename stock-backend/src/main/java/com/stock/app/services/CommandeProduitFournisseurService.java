package com.stock.app.services;

import com.stock.app.models.CommandeProduitFournisseur;
import com.stock.app.repositories.CommandeProduitFournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeProduitFournisseurService {

    private final CommandeProduitFournisseurRepository commandeProduitFournisseurRepository;

    @Autowired
    public CommandeProduitFournisseurService(CommandeProduitFournisseurRepository commandeProduitFournisseurRepository) {
        this.commandeProduitFournisseurRepository = commandeProduitFournisseurRepository;
    }

    public List<CommandeProduitFournisseur> getCommandeProduitFournisseursByCommandeFournisseurId(Long commandeFournisseurId) {
        return commandeProduitFournisseurRepository.findByCommandeFournisseur_Id(commandeFournisseurId);
    }

    public List<CommandeProduitFournisseur> getCommandeProduitFournisseursByProduitId(Long produitId) {
        return commandeProduitFournisseurRepository.findByProduitFini_Id(produitId);
    }

    // Méthodes CRUD de base

    public Page<CommandeProduitFournisseur> getAllCommandeProduitsFournisseurs(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return commandeProduitFournisseurRepository.findAll(pageable);
    }

    public CommandeProduitFournisseur getCommandeProduitFournisseurById(Long id) {
        return commandeProduitFournisseurRepository.findById(id).orElse(null);
    }

    public CommandeProduitFournisseur addCommandeProduitClient(CommandeProduitFournisseur commandeProduitFournisseur) {
        return commandeProduitFournisseurRepository.save(commandeProduitFournisseur);
    }
    public CommandeProduitFournisseur updateCommandeProduitFournisseur(CommandeProduitFournisseur commandeProduitFournisseur) {
        return commandeProduitFournisseurRepository.saveAndFlush(commandeProduitFournisseur);
    }

    public void deleteCommandeProduitFournisseurById(Long id) {
        commandeProduitFournisseurRepository.deleteById(id);
    }
}
