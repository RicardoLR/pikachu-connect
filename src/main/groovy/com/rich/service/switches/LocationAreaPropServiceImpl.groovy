package com.rich.service.switches

import com.rich.client.dto.PokemonDTO
import com.rich.constant.ServiceConstant
import com.rich.model.GetPokemonLocationAreaEncountersResponse
import com.rich.model.GetPropsResponse
import com.rich.service.SoapService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
@Qualifier("locationAreaPropServiceImpl")
class LocationAreaPropServiceImpl implements RequesSoapService {

    @Autowired SoapService service

    @Override
    GetPropsResponse process(String name, String ip) {
        PokemonDTO dto = service.fetchProps(name, ip, ServiceConstant.METHOD_NAME_LOCATION_AREA_ENCOUNTERS)
        new GetPropsResponse(locationArea: new GetPokemonLocationAreaEncountersResponse(
                data: dto.getLocationAreaEncounters() as String))
    }
}