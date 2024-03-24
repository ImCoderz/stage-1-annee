package com.stock.app.services;

import com.stock.app.models.CommandeFournisseur;
import com.stock.app.repositories.CommandeFournisseurRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommandeFournisseurService {

    private final CommandeFournisseurRepository commandeFournisseurRepository;

    public Page<CommandeFournisseur> getAllCommandesFournisseur(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return commandeFournisseurRepository.findAll(pageable);
    }

    public CommandeFournisseur getCommandeFournisseurById(Long id) {
        return commandeFournisseurRepository.findById(id).orElse(null);
    }

    public CommandeFournisseur addCommandeFournisseur(CommandeFournisseur commandeFournisseur) {
        return commandeFournisseurRepository.save(commandeFournisseur);
    }

    public CommandeFournisseur updateCommandeFournisseur(CommandeFournisseur commandeFournisseur) {
        return commandeFournisseurRepository.saveAndFlush(commandeFournisseur);
    }

    public void deleteCommandeFournisseurById(Long id) {
        commandeFournisseurRepository.deleteById(id);
    }
}
