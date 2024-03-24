package com.stock.app.repositories;

import com.stock.app.models.PVReception;
import com.stock.app.models.ProduitPVReception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitPVReceptionRepository extends JpaRepository<ProduitPVReception, Long> {
    List<ProduitPVReception> findByProduitFini_Id(Long factureFournisseurId);
    List<ProduitPVReception> findByPvReception_Id(Long pvReception);

}

