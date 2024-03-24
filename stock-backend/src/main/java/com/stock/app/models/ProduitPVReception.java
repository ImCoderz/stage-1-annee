package com.stock.app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class ProduitPVReception {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantiteTheoriqueRecue;
    private int quantiteManquante;
    private int quantiteAvérée;
    
    @ManyToOne
    @JoinColumn(name = "produit_id")
    private ProduitFini produitFini;

    @ManyToOne
    @JoinColumn(name = "pv_reception_id")
    private PVReception pvReception;

}
