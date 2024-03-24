package com.stock.app.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class FactureFournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateFacture;
    private double prixTotal;


    @OneToMany(mappedBy ="factureFournisseur" ,fetch = FetchType.LAZY)
    private List<PVReception> pvReceptions;

    @ManyToOne
    private CommandeFournisseur commandeFournisseur;

    @OneToMany(mappedBy ="factureFournisseur",fetch = FetchType.LAZY)
    private List<ProduitFactureFournisseur> produitFactureFournisseurs;

}
