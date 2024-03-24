package com.stock.app.repositories;

import com.stock.app.models.ProduitFactureClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProduitFactureClientRepository extends JpaRepository<ProduitFactureClient,Long> {
    List<ProduitFactureClient> findByFactureClient_Id(Long factureclientid);

    // Méthode pour trouver les commandes produits clients par ID du produit
    List<ProduitFactureClient> findByProduitFini_Id(Long produitId);

}
