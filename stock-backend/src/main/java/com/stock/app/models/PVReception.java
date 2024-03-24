package com.stock.app.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class PVReception {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateReception;

    @ManyToOne
    @JoinColumn(name = "facture_id")
    private FactureFournisseur factureFournisseur;

    @OneToMany(mappedBy ="pvReception",fetch = FetchType.LAZY)
    private List<ProduitPVReception> produitPVReceptions;

}

