package com.stock.app.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitQuantite {
    Long ProduitId;
    private int quantite;
}
