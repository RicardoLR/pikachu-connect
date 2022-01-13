package com.rich.service.switches

import com.rich.client.dto.PokemonDTO
import com.rich.constant.ServiceConstant
import com.rich.converter.ObjectConverter
import com.rich.model.GetPokemonResponse
import com.rich.model.GetPropsResponse
import com.rich.model.Pokemon
import com.rich.service.SoapService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
@Qualifier("allPropServiceImpl")
class AllPropServiceImpl implements RequesSoapService {

    @Autowired SoapService service
    @Autowired ObjectConverter objectConverter

    @Override
    GetPropsResponse process(String name, String ip) {
        GetPokemonResponse all = new GetPokemonResponse()
        PokemonDTO dto = service.fetchProps(name, ip, ServiceConstant.METHOD_NAME_ALL)
        all.setData(new Pokemon(
                id: dto.getId() as BigInteger,
                abilities: objectConverter.fromObject(dto.getAbilities().toList()),
                baseExperience: dto.getBaseExperience() as BigInteger,
                heldItems: dto.getHeldItems().toString(),
                locationAreaEncounters: dto.getLocationAreaEncounters() as String,
        ))
        new GetPropsResponse(
                all: all
        )
    }
}
