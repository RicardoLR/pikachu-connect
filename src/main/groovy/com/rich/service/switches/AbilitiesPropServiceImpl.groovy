package com.rich.service.switches

import com.rich.client.dto.PokemonDTO
import com.rich.constant.ServiceConstant
import com.rich.converter.ObjectConverter
import com.rich.model.GetPokemonAbilitiesResponse
import com.rich.model.GetPropsResponse
import com.rich.service.SoapService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
@Qualifier("abilitiesPropServiceImpl")
class AbilitiesPropServiceImpl implements RequesSoapService {

    @Autowired SoapService service
    @Autowired ObjectConverter objectConverter

    @Override
    GetPropsResponse process(String name, String ip) {
        PokemonDTO dto = service.fetchProps(name, ip, ServiceConstant.METHOD_NAME_ABILITIES)
        new GetPropsResponse(abilities: new GetPokemonAbilitiesResponse(
                data: objectConverter.fromObject(dto.getAbilities().toList())))
    }
}