package com.stock.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.app.models.CommandeClient;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CommandeClientRepository extends JpaRepository<CommandeClient, Long> {
    // Méthode pour trouver les commandes clients par ID du client
    List<CommandeClient> findByClientId(Long clientId);

    // Méthode pour trouver les commandes clients par ID de la boutique
    List<CommandeClient> findByBoutiqueId(Long boutiqueId);
}



