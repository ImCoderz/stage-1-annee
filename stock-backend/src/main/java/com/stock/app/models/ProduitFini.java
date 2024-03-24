package com.stock.app.models;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class ProduitFini {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String intitule;
    private double prixUnitaire;
    private String description;
    private int quantiteStock;
    private String codeBarres;
    private String categorie;
    private String fournisseur;
    private Date dateCreation;
    private Date dateDerniereMiseAJour;
    @ManyToOne
    @JoinColumn(name = "boutique_id")
    private Boutique boutique;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy ="produitFini",fetch = FetchType.LAZY)
    private List<CommandeProduitClient> commandeProduitClients;

    @OneToMany(mappedBy ="produitFini",fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<CommandeProduitFournisseur> commandeProduitFournisseurs;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy ="produitFini",fetch = FetchType.LAZY)
    private List<ProduitFactureClient> produitFactureClients;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy ="produitFini",fetch = FetchType.LAZY)
    private List<ProduitFactureFournisseur> produitFactureFournisseurs;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy ="produitFini",fetch = FetchType.LAZY)
    private List<ProduitPVReception> produitPVReceptions;

}
