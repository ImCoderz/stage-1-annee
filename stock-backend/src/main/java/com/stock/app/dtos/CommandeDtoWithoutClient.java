package com.stock.app.dtos;

import com.stock.app.models.Boutique;
import com.stock.app.models.Client;
import com.stock.app.models.CommandeProduitClient;
import com.stock.app.models.FactureClient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandeDtoWithoutClient {
    private Long id;
    private LocalDate dateCommande;
    private Boutique boutique;
}
