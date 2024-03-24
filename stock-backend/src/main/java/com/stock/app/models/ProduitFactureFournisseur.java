package com.stock.app.models;

import java.time.LocalDate;

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
public class ProduitFactureFournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantite;
    private LocalDate dateFabrication;
    private LocalDate dateExpiration;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private ProduitFini produitFini;

    @ManyToOne
    @JoinColumn(name = "facture_fournisseur_id")
    private FactureFournisseur factureFournisseur;

}
