package com.stock.app.repositories;

import java.util.List;
import java.util.Optional;

import com.stock.app.models.CommandeProduitFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.app.models.CommandeProduitClient;

@Repository
public interface CommandeProduitFournisseurRepository extends JpaRepository<CommandeProduitFournisseur, Long> {

    // Méthode pour trouver les commandes produits clients par ID de la commande client
    List<CommandeProduitFournisseur> findByCommandeFournisseur_Id(Long commandeClientId);

    // Méthode pour trouver les commandes produits clients par ID du produit
    List<CommandeProduitFournisseur> findByProduitFini_Id(Long produitId);
}
