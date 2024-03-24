package com.stock.app.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.stock.app.dtos.ClientDto;
import com.stock.app.dtos.CommandeDtoWithoutFournisseur;
import com.stock.app.dtos.FournisseurDto;
import com.stock.app.mappers.ClientMapper;
import com.stock.app.models.Client;
import com.stock.app.models.CommandeFournisseur;
import com.stock.app.models.Fournisseur;
import org.springframework.stereotype.Component;

import com.stock.app.dtos.CommandeDtoWithoutClient;
import com.stock.app.models.CommandeClient;

@Component
public class FournisseurMapperImpl implements FournisseurMapper {

    @Override
    public FournisseurDto fournisseurToFournisseurDto(Fournisseur fournisseur) {
        if (fournisseur == null) {
            return null;
        }

        FournisseurDto fournisseurDto = new FournisseurDto();
        fournisseurDto.setId(fournisseur.getId());
        fournisseurDto.setNom(fournisseur.getNom());
        fournisseurDto.setAdresse(fournisseur.getAdresse());
        fournisseurDto.setEmail(fournisseur.getEmail());
        fournisseurDto.setNumeroTelephone(fournisseur.getNumeroTelephone());
        fournisseurDto.setCommandesFournisseur(mapCommandes(fournisseur.getCommandesFournisseur()));
        return fournisseurDto;
    }


    @Override
    public List<CommandeDtoWithoutFournisseur> mapCommandes(List<CommandeFournisseur> commandes) {
        return commandes.stream()
                .map(commandeFournisseur -> {
                    CommandeDtoWithoutFournisseur commandeDto = new CommandeDtoWithoutFournisseur();
                    // Map attributes from CommandeClient to CommandeDtoWithoutClient
                    commandeDto.setId(commandeFournisseur.getId());
                    commandeDto.setDateCommande(commandeFournisseur.getDateCommande());
                    commandeDto.setBoutique(commandeFournisseur.getBoutique());
                    // Map other attributes as needed
                    return commandeDto;
                })
                .collect(Collectors.toList());
    }
}
