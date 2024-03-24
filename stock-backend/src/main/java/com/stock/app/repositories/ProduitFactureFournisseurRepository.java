package com.stock.app.repositories;

import com.stock.app.models.ProduitFactureClient;
import com.stock.app.models.ProduitFactureFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProduitFactureFournisseurRepository extends JpaRepository<ProduitFactureFournisseur,Long> {
    List<ProduitFactureFournisseur> findByFactureFournisseur_Id(Long factureclientid);

    // Méthode pour trouver les commandes produits clients par ID du produit
    List<ProduitFactureFournisseur> findByProduitFini_Id(Long produitId);

}
