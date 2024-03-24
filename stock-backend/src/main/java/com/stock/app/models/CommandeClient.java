package com.stock.app.models;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandeClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "La date de commande est requise")
    private LocalDate dateCommande;
    @ManyToOne()
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "boutique_id")
    private Boutique boutique;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy ="commandeClient",fetch = FetchType.LAZY)
    private List<CommandeProduitClient> commandeProduitClientLists;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "commandeClient",fetch = FetchType.LAZY)
    private  List<FactureClient> factureClients;

}
