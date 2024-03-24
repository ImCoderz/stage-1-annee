package com.stock.app.repositories;

import com.stock.app.models.FactureFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.app.models.FactureClient;

import java.util.List;

import com.stock.app.models.Boutique;

import java.util.Optional;

@Repository
public interface FactureFournisseurRepository extends JpaRepository<FactureFournisseur, Long> {

    // Méthode pour obtenir toutes les factures clients associées à une boutique

}

