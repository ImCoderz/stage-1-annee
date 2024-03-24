package com.stock.app.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class FactureClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateFacture;
    private boolean paiement;
    private double prixTotal;

    @ManyToOne
    @JoinColumn(name = "commande_id")
    private CommandeClient commandeClient;


    @OneToMany(mappedBy = "factureClient",fetch = FetchType.LAZY)
    private List<ProduitFactureClient> produitFactureClients;


}
