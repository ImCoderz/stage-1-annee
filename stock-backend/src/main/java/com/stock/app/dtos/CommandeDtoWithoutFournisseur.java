package com.stock.app.dtos;

import com.stock.app.models.Boutique;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandeDtoWithoutFournisseur {

    private Long id;
    private LocalDate dateCommande;
    private Boutique boutique;
}
