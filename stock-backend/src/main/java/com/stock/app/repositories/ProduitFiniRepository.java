package com.stock.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.app.models.ProduitFini;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProduitFiniRepository extends JpaRepository<ProduitFini, Long> {

    List<ProduitFini> findByBoutique_Id(Long boutique);

}
