package com.stock.app.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FournisseurDto {
    private Long id;
    private String nom;
    private String adresse;
    private String email;
    private String numeroTelephone;
    private List<CommandeDtoWithoutFournisseur> commandesFournisseur;

}
