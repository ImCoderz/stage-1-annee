package com.stock.app.mappers;

import com.stock.app.dtos.ClientDto;
import com.stock.app.dtos.CommandeDtoWithoutClient;
import com.stock.app.dtos.CommandeDtoWithoutFournisseur;
import com.stock.app.dtos.FournisseurDto;
import com.stock.app.models.Client;
import com.stock.app.models.CommandeClient;
import com.stock.app.models.CommandeFournisseur;
import com.stock.app.models.Fournisseur;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface FournisseurMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(source = "commandesFournisseur", target = "commandesFournisseur")
    FournisseurDto fournisseurToFournisseurDto(Fournisseur fournisseur);


    List<CommandeDtoWithoutFournisseur> mapCommandes(List<CommandeFournisseur> commandes);
}
