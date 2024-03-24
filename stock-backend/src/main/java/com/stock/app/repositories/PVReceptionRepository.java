package com.stock.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.app.models.PVReception;

import java.util.List;
import java.util.Optional;

@Repository
public interface PVReceptionRepository extends JpaRepository<PVReception, Long> {
    List<PVReception> findByFactureFournisseur_Id(Long factureFournisseurId);
}

