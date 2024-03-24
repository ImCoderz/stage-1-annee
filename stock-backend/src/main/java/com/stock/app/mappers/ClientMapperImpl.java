package com.stock.app.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.stock.app.dtos.ClientDto;
import com.stock.app.mappers.ClientMapper;
import com.stock.app.models.Client;
import org.springframework.stereotype.Component;

import com.stock.app.dtos.CommandeDtoWithoutClient;
import com.stock.app.models.CommandeClient;

@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDto clientToClientDto(Client client) {
        if (client == null) {
            return null;
        }

        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setNom(client.getNom());
        clientDto.setPrenom(client.getPrenom());
        clientDto.setAdresse(client.getAdresse());
        clientDto.setEmail(client.getEmail());
        clientDto.setNumeroTelephone(client.getNumeroTelephone());
        clientDto.setNumeroRegistreCommerce(client.getNumeroRegistreCommerce());
        clientDto.setNumeroMatriculeFiscale(client.getNumeroMatriculeFiscale());
        clientDto.setCommandes(mapCommandes(client.getCommandes()));
        return clientDto;
    }


    @Override
    public List<CommandeDtoWithoutClient> mapCommandes(List<CommandeClient> commandes) {
        return commandes.stream()
                .map(commandeClient -> {
                    CommandeDtoWithoutClient commandeDto = new CommandeDtoWithoutClient();
                    // Map attributes from CommandeClient to CommandeDtoWithoutClient
                    commandeDto.setId(commandeClient.getId());
                    commandeDto.setDateCommande(commandeClient.getDateCommande());
                    commandeDto.setBoutique(commandeClient.getBoutique());
                    // Map other attributes as needed
                    return commandeDto;
                })
                .collect(Collectors.toList());
    }
}
