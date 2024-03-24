package com.stock.app.mappers;

import com.stock.app.dtos.ClientDto;
import com.stock.app.dtos.ClientWithoutCommandDto;
import com.stock.app.dtos.CommandeClientDto;
import com.stock.app.dtos.CommandeDtoWithoutClient;
import com.stock.app.models.Client;
import com.stock.app.models.CommandeClient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CommandeClientMapper {

    CommandeClientMapper INSTANCE = Mappers.getMapper(CommandeClientMapper.class);

    @Mapping(source = "client", target = "client")
    CommandeClientDto commandeClientTocommandeClientDto(CommandeClient commandeClient);

    ClientWithoutCommandDto clientToClientDto(Client client);

}
