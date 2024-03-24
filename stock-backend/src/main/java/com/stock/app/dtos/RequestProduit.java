package com.stock.app.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestProduit {
    Long clientId;
    Long boutiqueId;
    List<ProduitQuantite> produitQuantites;
}
