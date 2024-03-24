package com.stock.app.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientWithoutCommandDto {
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String numeroTelephone;
    private String numeroRegistreCommerce;
    private String numeroMatriculeFiscale;
}
