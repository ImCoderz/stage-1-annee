package com.stock.app.mappers;

import com.stock.app.dtos.CommandeDtoWithoutClient;
import com.stock.app.models.CommandeClient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.stock.app.dtos.ClientDto;
import com.stock.app.models.Client;

import java.util.List;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(source = "commandes", target = "commandes")
    ClientDto clientToClientDto(Client client);

    List<CommandeDtoWithoutClient> mapCommandes(List<CommandeClient> commandes);

}
