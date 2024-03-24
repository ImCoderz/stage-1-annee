package com.stock.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stock.app.models.CommandeFournisseur;
import java.util.List;
import java.util.Optional;

@Repository
public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Long> {

    // Méthode pour trouver les commandes fournisseurs par ID du fournisseur
    List<CommandeFournisseur> findByFournisseurId(Long fournisseurId);

    // Méthode pour trouver les commandes fournisseurs par ID de la boutique
    List<CommandeFournisseur> findByBoutiqueId(Long boutiqueId);
}
