package com.stock.app.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandeFournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "La date de commande est requise")
    private LocalDate dateCommande;
    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;
    @ManyToOne
    @JoinColumn(name = "boutique_id")
    private Boutique boutique;
    @OneToMany(mappedBy ="commandeFournisseur",fetch = FetchType.LAZY)
    private List<CommandeProduitFournisseur> commandeProduitFournisseurs;
    @OneToMany(mappedBy = "commandeFournisseur",fetch = FetchType.LAZY)
    private  List<FactureFournisseur> factureFournisseurs;

}
