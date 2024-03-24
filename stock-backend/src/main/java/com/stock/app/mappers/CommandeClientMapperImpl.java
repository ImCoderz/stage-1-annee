package com.stock.app.mappers;

import com.stock.app.dtos.ClientDto;
import com.stock.app.dtos.ClientWithoutCommandDto;
import com.stock.app.dtos.CommandeClientDto;
import com.stock.app.models.Client;
import com.stock.app.models.CommandeClient;
import org.springframework.stereotype.Component;

@Component
public class CommandeClientMapperImpl implements CommandeClientMapper {
    @Override
    public CommandeClientDto commandeClientTocommandeClientDto(CommandeClient commandeClient) {
        CommandeClientDto commandeClientDto=new CommandeClientDto();
        commandeClientDto.setDateCommande(commandeClient.getDateCommande());
        commandeClientDto.setId(commandeClient.getId());
        commandeClientDto.setBoutique(commandeClient.getBoutique());
        commandeClientDto.setClient(clientToClientDto(commandeClient.getClient()));
        return commandeClientDto;
    }

    @Override
    public ClientWithoutCommandDto clientToClientDto(Client client) {
        if (client == null) {
            return null;
        }
        ClientWithoutCommandDto clientWithoutCommandDto = new ClientWithoutCommandDto();
        clientWithoutCommandDto.setId(client.getId());
        clientWithoutCommandDto.setNom(client.getNom());
        clientWithoutCommandDto.setPrenom(client.getPrenom());
        clientWithoutCommandDto.setAdresse(client.getAdresse());
        clientWithoutCommandDto.setEmail(client.getEmail());
        clientWithoutCommandDto.setNumeroTelephone(client.getNumeroTelephone());
        clientWithoutCommandDto.setNumeroRegistreCommerce(client.getNumeroRegistreCommerce());
        clientWithoutCommandDto.setNumeroMatriculeFiscale(client.getNumeroMatriculeFiscale());
        return clientWithoutCommandDto;
    }


}
