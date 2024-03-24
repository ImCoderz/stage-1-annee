package com.stock.app.dtos;

import com.stock.app.models.Boutique;
import com.stock.app.models.Client;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandeClientDto {
    private Long id;
    private LocalDate dateCommande;
    private ClientWithoutCommandDto client;
    private Boutique boutique;
}
