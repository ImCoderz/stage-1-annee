package com.stock.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.app.models.CommandeProduitClient;

@Repository
public interface CommandeProduitClientRepository extends JpaRepository<CommandeProduitClient, Long> {

    // Méthode pour trouver les commandes produits clients par ID de la commande client
    List<CommandeProduitClient> findByCommandeClientId(Long commandeClientId);

    // Méthode pour trouver les commandes produits clients par ID du produit
    List<CommandeProduitClient> findByProduitFini_Id(Long produitId);
}
